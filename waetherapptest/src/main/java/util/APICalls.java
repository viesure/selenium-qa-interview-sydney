package util;

import io.restassured.RestAssured;
import model.APIResponse;
import config.APIConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import static io.restassured.RestAssured.given;

public class APICalls {

    public static APIResponse getWeatherInfo(){
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept","*/*")
                .build();
        ResponseSpecification  responseSpec = new ResponseSpecBuilder().build();
        Response response = RestAssured.given()
                .when()
                .get(APIConstants.BASE_URL + APIConstants.WEATHER_ENDPOINT)
                .then()
                .extract().response();
        APIResponse apiResponse = Utils.responseToObject(response);
        return apiResponse;
    }
    public static void putWeatherCondition(Integer condition){
        System.out.println(condition);
        String bodyString = Utils.keyValueToJson("condition",condition);
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(bodyString)
                .when()
                .put(APIConstants.BASE_URL + APIConstants.CONDITION_ENDPOINT)
                .then()
                .extract().response();
    }
    public static void putTemperature(Integer temp){
        String bodyString =  Utils.keyValueToJson("tempInFahrenheit",temp);
        Response response = RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(bodyString)
                .when()
                .put(APIConstants.BASE_URL + APIConstants.TEMPERATURE_ENDPOINT)
                .then()
                .extract().response();
        response.print();
    }


}
