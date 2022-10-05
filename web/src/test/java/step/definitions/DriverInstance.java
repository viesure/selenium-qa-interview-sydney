package definitions;

import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInstance {

    public ChromeDriver driver = new ChromeDriver();

    @After
    public void TearDown() {
        driver.quit();
    }
}
