package leti.tests;

import com.codeborne.selenide.Selenide;
import frame.ConfigReader;
import frame.leti.page.HomePage;
import frame.leti.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
//
//    @Test
//    @Tag("leti")
//    public void testLoginButtonClick() {
//        String email = ConfigReader.getProperty("email");
//        String password = ConfigReader.getProperty("password");
//
//        LoginPage loginPage = new LoginPage();
//        loginPage.openPage();
//
//        Assertions.assertTrue(loginPage.isDisplayed(), "Страница логина не отобразилась");
//        loginPage.login(email, password);
//
//        HomePage homePage = new HomePage();
//        Selenide.sleep(5000);
//        Assertions.assertTrue(homePage.isDisplayed(), "Домашняя страница не отобразилась после логина");
//    }
//
//    @Test
//    @Tag("leti")
//    public void testLoginWithEmptyFields() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.openPage();
//        Assertions.assertTrue(loginPage.isDisplayed(), "Страница логина не отобразилась");
//        loginPage.clickLoginButton();
//        Assertions.assertTrue(loginPage.isDisplayed(), "Страница логина должна оставаться отображенной при пустых полях");
//    }

    @Test
    @Tag("leti")
    public void testLoginWithInvalidPassword() {
        String email = ConfigReader.getProperty("email");

        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.enterUsername(email);
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLoginButton();
        Selenide.sleep(5000);
        Assertions.assertTrue(loginPage.isErrorMessageDisplayed(), "Сообщение об ошибке не появилось при неверном пароле");
        Assertions.assertEquals("Электронная почта или пароль введены неправильно", loginPage.getErrorMessage(), "Текст ошибки не совпадает");
    }

    @Test
    @Tag("leti")
    public void testLoginWithInvalidEmail() {
        String password = ConfigReader.getProperty("password");

        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.enterUsername("invalid@example.com");
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Selenide.sleep(5000);
        Assertions.assertTrue(loginPage.isErrorMessageDisplayed(), "Сообщение об ошибке не появилось при неверном пароле");
        Assertions.assertEquals("Электронная почта или пароль введены неправильно", loginPage.getErrorMessage(), "Текст ошибки не совпадает");
    }
}