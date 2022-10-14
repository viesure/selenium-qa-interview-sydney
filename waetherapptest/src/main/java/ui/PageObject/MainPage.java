package ui.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;



public class MainPage {
    @FindBy(xpath="//div[@id=\"desktop-menu\"]//input[@name=\"q\"]")
    private WebElement searchInput;
    @FindBy(xpath="//nav")
    private WebElement navbar;


    public MainPage(WebDriver webdriver){
        PageFactory.initElements(webdriver,this);
    }

    public String getPlaceholderText(){
        String placeholderText = searchInput.getAttribute("placeholder");
        return placeholderText;
    }
    public void searchFor(String cityName){
        searchInput.sendKeys(cityName);
        searchInput.sendKeys(Keys.RETURN);
    }
    public boolean navbarVisible(){
       return navbar.isDisplayed();
    }

}
