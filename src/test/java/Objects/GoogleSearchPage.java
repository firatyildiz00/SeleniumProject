package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    WebDriver driver;
    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='q']")  WebElement searchBox;
    @FindBy(xpath = "(//input[@name='btnK'])[1]") WebElement searchBtn;
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3") WebElement facebookLink;

    public void searchGoogle(String SearchInput){
        try {
            searchBox.sendKeys(SearchInput);
            searchBtn.click();

        }catch (Exception e){
            System.out.println("Exception Caught" + e.getMessage());
        }
    }
    public void ClickFacebook(){
        try {
            facebookLink.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
