package leti.tests;

import frame.ConfigReader;
import frame.leti.page.HomePage;
import frame.leti.page.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LogoutTest {

//    @Test
//    @Tag("leti")
//    public void testLogout() {
//        String email = ConfigReader.getProperty("email");
//        String password = ConfigReader.getProperty("password");
//
//        // Вход в систему
//        LoginPage loginPage = new LoginPage();
//        loginPage.openPage();
//        loginPage.login(email, password);
//
//        // Проверяем, что вошли на HomePage
//        HomePage homePage = new HomePage();
//        homePage.isDisplayed();
//
//        // Выход из системы
////        homePage.logout();
////        $x("//div[contains(@class, 'dropdown-content')]").shouldBe(visible);
//        // Проверяем, что мы вернулись на страницу логина
//        //loginPage.isDisplayed();
//    }
}