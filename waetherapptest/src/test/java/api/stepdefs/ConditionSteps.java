package api.stepdefs;

import api.APICalls;
import api.model.APIResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class ConditionSteps {

    @When("set the weather condition to {int}")
    public void changeWeatherCondition(Integer condition){
       APICalls.putWeatherCondition(condition);
    }
    @Then("the icon png should contain {string}")
    public void checkIcon(String iconName){
        String fileFormat = ".png";
        APIResponse apiResponse = APICalls.getWeatherInfo();
        String icon = apiResponse.getIcon();
        Assert.assertEquals(icon,iconName+fileFormat);
    }
    @Then("the condition should be {string}")
    public void checkCondition(String condition){
        APIResponse apiResponse = APICalls.getWeatherInfo();
        Assert.assertEquals(condition,apiResponse.getCondition());
    }
}
