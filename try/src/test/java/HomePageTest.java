import frame.page.HomePage;
import frame.element.Button;
import org.junit.jupiter.api.Test;

public class HomePageTest {

    @Test
    public void testBuyButtonClick() {
        HomePage homePage = new HomePage();
        homePage.openPage();
        Button buyButton = new Button("//*[@id='stickyHeader']/div/a/img");
        // Ждем, пока кнопка станет видимой
        buyButton.waitForVisible();
        // Кликаем по кнопке
        buyButton.click();
    }
}
