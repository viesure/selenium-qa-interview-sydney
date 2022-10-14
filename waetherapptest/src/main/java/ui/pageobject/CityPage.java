package ui.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CityPage {
    @FindBy (xpath = "//span[@class=\"orange-text\"]")
    private WebElement date;

    @FindBy (xpath = "//h2")
    private WebElement cityName;

    public CityPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);

    }

    public String getDateText(){
         return date.getText();
    }
    public String getCityNameText(){
        return cityName.getText();
    }
}
