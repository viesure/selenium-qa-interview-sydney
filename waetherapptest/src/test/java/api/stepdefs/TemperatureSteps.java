package api.stepdefs;
import util.APICalls;
import model.APIResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TemperatureSteps extends APICalls {
    @When("set the temperature to {int}")
    public void changeTemperature(Integer temp){
        APICalls.putTemperature(temp);
    }
    @Then("the temperature in fahrenheit should be {int}")
    public void checkFahrenheit(Integer fahrenheit){
        APIResponse apiResponse = APICalls.getWeatherInfo();
        Assert.assertEquals(fahrenheit,apiResponse.getWeather().getTempInFahrenheit());
    }
    @Then("the temperature in celsius should be {int}")
    public void checkCelsius(Integer celsius){
        APIResponse apiResponse = APICalls.getWeatherInfo();
        Assert.assertEquals(celsius,apiResponse.getWeather().getTempInCelsius());
    }
    @Then("the description should contain {string}")
    public void checkDescription(String descriptionAdj){
        APIResponse apiResponse = APICalls.getWeatherInfo();
        Assert.assertEquals(apiResponse.getDescription(),"The weather is "+descriptionAdj);
    }

}
