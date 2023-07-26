package ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import ui.driver.DriverSingleton;
import ui.pages.AuthorizationFormPage;
import ui.pages.HomePage;

public class BaseUITest {
  static DriverSingleton driverSingleton;
  static HomePage homePage;
  static AuthorizationFormPage authorizationFormPage;

    @BeforeAll
    public static void setUp() {
      WebDriver driver = driverSingleton.getDriver();
      homePage = new HomePage(driver);
      authorizationFormPage = new AuthorizationFormPage(driver);
      homePage.startMarko();
      homePage.clickButtonQuizClose();
      homePage.clickButtonCookie();
    }

    @AfterAll
    public static void tearDown(){
       DriverSingleton.quitDriver();
    }
}