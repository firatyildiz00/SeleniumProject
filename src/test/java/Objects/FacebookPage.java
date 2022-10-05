package Objects;

import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage {
    WebDriver driver;
    public FacebookPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "email") WebElement username_editBox;
    @FindBy(id = "pass") WebElement password_editBox;
    @FindBy(xpath = "//*[@id=\"u_0_5_cu\"]") WebElement login_Btn;

    public void EnterUsername(){
        username_editBox.sendKeys("Testuser");
    }
    public void EnterPassword(){
        password_editBox.sendKeys("Tester123");
    }
    public void VerifyLogin(){
        login_Btn.click();
        String title = driver.getTitle();
        assertEquals(title, "Login page");
    }
}



















