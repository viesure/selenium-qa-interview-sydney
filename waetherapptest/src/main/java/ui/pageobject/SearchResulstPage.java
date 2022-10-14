package ui.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResulstPage {
    @FindBy(xpath = "//tr[1]//a[1]")
    private WebElement sydney;

    public SearchResulstPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver,this);
    }

    public void clickOnSydney(){
        sydney.click();
    }


}
