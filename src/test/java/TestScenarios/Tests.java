package TestScenarios;
import Objects.FacebookPage;
import Objects.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {
    WebDriver driver;
    GoogleSearchPage objectrepo = new GoogleSearchPage(driver);
    FacebookPage page = new FacebookPage(driver);

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
    }
    @Test
    public void SearchOperation() {
        objectrepo.searchGoogle("facebook");
    }
    @Test
    public void VerifyAndAccessFacebook(){
        objectrepo = new GoogleSearchPage(driver);
        objectrepo.ClickFacebook();
    }
    @Test
    public void VerifyLogin(){
        page.EnterUsername();
        page.EnterPassword();
        page.VerifyLogin();
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
