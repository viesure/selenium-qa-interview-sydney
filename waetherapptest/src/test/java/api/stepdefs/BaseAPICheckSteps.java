package api.stepdefs;

import api.APICalls;
import api.model.APIResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class BaseAPICheckSteps {
    @Given("a working API")
    public void checkAPI(){
        APIResponse apiResponse = APICalls.getWeatherInfo();
        Assert.assertNotNull( apiResponse.getCity());
    }
    @Then("the city name should be Vienna")
    public void checkCityName(){
        APIResponse apiResponse = APICalls.getWeatherInfo();
        Assert.assertEquals(apiResponse.getCity(),"Vienna");
    }
}
