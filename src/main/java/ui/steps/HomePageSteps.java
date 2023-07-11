package ui.steps;

import org.openqa.selenium.WebDriver;
import ui.pages.AuthorizationFormPage;
import ui.pages.HomePage;

public class HomePageSteps {
    HomePage homePage;
    AuthorizationFormPage authorizationFormPage;


    public HomePageSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        authorizationFormPage = new AuthorizationFormPage(driver);
    }
    public HomePageSteps fillSearchFormFieldAndClickSubmit() {
        homePage.fillSearchForm("туфли")
                .clickButtonSearch();
        return this;
    }
}
