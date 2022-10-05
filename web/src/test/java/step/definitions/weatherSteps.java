package step.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.*;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class weatherSteps {
    private final ChromeDriver driver;
    public weatherSteps(DriverInstance chromeDriver) {
        this.driver = chromeDriver.driver;
    }

    @When("landing page is open")
    public void landingPageIsOpen() {
        driver.get("https://openweathermap.org/");

    }

    @Then("placeholder text contains {string}")
    public void placeholderTextContains(String placeholderText) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeToBe(By.name("q"),"placeholder", placeholderText));
    }

    @And("user searches for {string}")
    public void userSearchesFor(String city) throws InterruptedException {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("owm-loader")));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".search input")))
                .sendKeys(city);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search button")))
                .click();
    }

    @And("user selects {string} from the list")
    public void userSelectsFromTheList(String cityListItem) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),\"Sydney, AU\")]")))
                .click();
    }

    @Then("The results for correct {string} are displayed, with date and time according to {string} timezone")
    public void theResultsForCorrectAreDisplayedWithDateAndTimeAccordingToTimezone(String city, String timezoneID) {
        String actualCity = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),\"Sydney, AU\")]")))
                .getText();
        assertTrue(actualCity.contains(city), city + " was found and correctly displayed");

        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("MMM d, hh:mma");
        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(timezoneID));
        String currentDateTimeInTimezoneID = dateTime.format(dateTimeFormat);

        String actualDateTime = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".current-container .orange-text")))
                .getText();

        assertEquals(currentDateTimeInTimezoneID, actualDateTime, "Date and Time are displayed according to " + timezoneID);
    }
}
