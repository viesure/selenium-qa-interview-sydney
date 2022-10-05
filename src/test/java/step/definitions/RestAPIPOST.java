package step.definitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestAPIPOST {
    private final String BASE_URL = "https://backend-interview-sydney.tools.gcp.viesure.io/";
    private Response response;
    private Scenario scenario;

    @Before
    public void before (Scenario scenario){
        this.scenario = scenario;
    }

    @Given("Get call to {string} api")
    public void getCallToApi(String url) throws URISyntaxException {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given();
        response = requestSpecification.when().get(new URI(url));
    }

    @Then("Response code is {string} OK")
    public void responseCodeIsOK(String statusCode) {
        int actualResponseCode = response.then().log().all().and().extract().statusCode();
        assertEquals(statusCode, actualResponseCode+"");
    }

    @And("City is {string}")
    public void cityIs(String city) {
        String actualCity = response.then().extract().path("city");
        assertEquals(city, actualCity.toLowerCase());
    }

    @And("Response JSON has valid schema")
    public void schemaIsValid() {
        String responseBody = response.then().extract().body().asPrettyString();
//        System.out.println("@@@@@@@@@@@"+responseBody);
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath("featureFiles/weather_api.json"));
    }

    @Given("PUT call to {string} with weather {string}")
    public void putCallToWithWeather(String url, String conditionID) throws URISyntaxException {
        RestAssured.baseURI = BASE_URL;
//        System.out.println(new URI(url));
        RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body("{\"condition\":" + conditionID + "}")
                .when()
                .put(new URI(url))
                .then().log().all();
    }

    @Then("Condition is {string}")
    public void conditionIs(String condition) {
        String actualCondition = response.then().extract().path("condition");
        assertEquals(condition, actualCondition.toLowerCase());
    }

    @And("ConditionID is {string}")
    public void conditionidIs(String conditionID) {
        String actualConditionID = response.then().extract().path("conditionID");
        assertEquals(conditionID, actualConditionID);
    }

    @Then("Response contains the {string}")
    public void responseContainsThe(String field) {
        String bodyAsString = response.getBody().asString();
//        String actualField = response.then().extract().path("\"" + field + "\"");
        assertEquals(bodyAsString.contains(field), true, "field " + field + " not present");
    }

    @And("Icon is {string}")
    public void iconIs(String icon) {
        String actualIcon = response.then().extract().path("icon");
        assertEquals(icon,actualIcon);
    }

    @Given("PUT call to {string} with temperature in {string}")
    public void putCallToWithTemperature(String url, String fahrenheit) throws URISyntaxException {
        RestAssured.baseURI = BASE_URL;
//        System.out.println(new URI(url));
        RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body("{\"tempInFahrenheit\":" + fahrenheit + "}")
                .when()
                .put(new URI(url))
                .then().log().all();
    }

    @And("Weather description ends with {string} for each temperature {string}")
    public void weatherDescriptionEndsWith(String description, String celsius) {
        String actualWeatherDescription = response.then().extract().path("description");
        String actuaTempInCelsius = response.then().extract().path("tempInCelsius");
        System.out.println(actualWeatherDescription);
        assertEquals("The weather is " + description, actualWeatherDescription, "Temperature in celsius is: " + actuaTempInCelsius);

    }
}
