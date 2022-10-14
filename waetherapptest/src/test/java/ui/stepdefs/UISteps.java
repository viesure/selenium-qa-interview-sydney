package ui.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pageobject.CityPage;
import ui.pageobject.MainPage;
import ui.pageobject.SearchResulstPage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class UISteps {
   public WebDriver webDriver;

    @Before("@UI")
    public void initializeWebdriver() {
        webDriver = WebDriverManager.chromedriver().create();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Given("browser is open on openweather url")
    public void browserIsOpenOnWithUrl() {
        String url = "https://openweathermap.org/";
        webDriver.get(url);

    }

    @When("the main page is visible")
    public void theMainPageIsVisible() {
        MainPage mainPage = new MainPage(webDriver);
        Assert.assertTrue(mainPage.navbarVisible());
    }

    @Then("search input should have correct text")
    public void searchInputShouldHaveCorrectText() {
        MainPage mainPage = new MainPage(webDriver);
        String placeHolderText = mainPage.getPlaceholderText();
        Assert.assertEquals(placeHolderText,"Weather in your city");
    }

    @When("the user searches for sydney")
    public void theUserSearchesForSydney() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.searchFor("Sydney");
    }

    @When("the user selects Sydney, Au from the list")
    public void theUserSelectsFromTheList() {
        SearchResulstPage searchResultsPage = new SearchResulstPage(webDriver);
        searchResultsPage.clickOnSydney();
    }

    @Then("the city name should be displayed correctly")
    public void theCityNameShouldBeDisplayedCorrectly() {
        CityPage cityPage = new CityPage(webDriver);
        String cityName = cityPage.getCityNameText();
        Assert.assertEquals(cityName,"Sydney, AU");
    }

    @Then("the date should be visible correctly")
    public void theDateShouldBeVisibleCorrectly() {
        CityPage cityPage = new CityPage(webDriver);
        String date = cityPage.getDateText();
        Date dateNow = new Date();

        DateFormat dateFormat = new SimpleDateFormat("MMM dd, hh:mmaaa", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+11:00"));
        String dateString =  dateFormat.format(dateNow);
        String expectedDate = dateString.split(",")[0].toLowerCase(Locale.ROOT);
        String expectedTime = dateString.split(",")[1].toLowerCase(Locale.ROOT);
        String actualDate = date.split(",")[0].toLowerCase(Locale.ROOT);
        String actualTime = date.split(",")[1].toLowerCase(Locale.ROOT);
        Assert.assertEquals(actualDate,expectedDate);
        Assert.assertEquals(actualTime,expectedTime);
    }

    @After("@UI")
    public void terDown(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println("failed test");
            System.out.println(scenario.getStatus());
        }
        webDriver.quit();
    }
}
