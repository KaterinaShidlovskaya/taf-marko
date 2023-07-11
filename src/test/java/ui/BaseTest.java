package ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.HomePage;
import ui.steps.AuthorizationPageSteps;

import java.time.Duration;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {
    protected HomePage homePage;
    protected AuthorizationPageSteps authorizationPageSteps;
    WebDriver driver;

    @BeforeAll
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        this.authorizationPageSteps = new AuthorizationPageSteps(driver);
        this.homePage = new HomePage(driver);
        this.homePage.getHomePage();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}