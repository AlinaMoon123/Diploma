package hh.tests;

import com.codeborne.selenide.Selenide;
import frame.hh.page.MainPage;
import frame.hh.page.SearchPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MainTest {

    @Test
    @Tag("hh")
    public void searchTest() {
        MainPage mainPage = new MainPage();
        mainPage.openPage();

        Assertions.assertTrue(mainPage.isDisplayed(), "Главная страница не отобразилась");

        mainPage.enterSearchRequest("аналитик");
        Assertions.assertTrue(mainPage.clearTextButtonIsDisplayed(), "Кнопка очистки поля не отображается");

        mainPage.clickSearchButton();
        if (mainPage.modalIsDisplayed()){
            mainPage.clickModal();
        }

        SearchPage searchPage = new SearchPage();
        Selenide.sleep(5000);
        Assertions.assertTrue(searchPage.isDisplayed(), "Страница поиска не отобразилась");
    }

    @Test
    @Tag("hh")
    public void searchClearTest() {
        MainPage mainPage = new MainPage();
        mainPage.openPage();

        Assertions.assertTrue(mainPage.isDisplayed(), "Главная страница не отобразилась");
        Assertions.assertTrue(mainPage.clearIsNotDisplayed(), "Кнопка очистки текста отображается до ввода данных");

        mainPage.enterSearchRequest("аналитик");
        Assertions.assertTrue(mainPage.clearTextButtonIsDisplayed(), "Кнопка очистки текста не появилась");

        mainPage.clickClearTextButton();
        Assertions.assertTrue(mainPage.searchInputIsEmpty(), "Поле поиска не очистилось");
    }
}
