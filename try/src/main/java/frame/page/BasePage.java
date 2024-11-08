package frame.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage<T extends BasePage<T>> {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    protected final SelenideElement basePage;
    protected final Class<T> pageClass;

    // Конструктор класса BasePage
    protected BasePage(Class<T> pageClass, String type) {
        this.pageClass = pageClass;
        // Элемент, который будет использоваться для нахождения страницы
        this.basePage = $(String.format("//div[contains(@name,'%s')]", type));
    }

    // Метод для обновления страницы
    public T refresh() {
        logger.info("Обновление страницы: " + pageClass.getSimpleName());
        Selenide.refresh();
        return Selenide.page(pageClass);  // Возвращаем экземпляр страницы типа T
    }

    // Метод для перехода на другую страницу
    public T page(Class<T> pageClass) {
        logger.info("Переход на страницу: " + pageClass.getSimpleName());
        return Selenide.page(pageClass);
    }

    // Метод для открытия страницы
    public void openPage() {
        String url = getDefaultUrl();
        if (url != null && !url.isEmpty()) {
            logger.info("Открытие страницы: " + url);
            Selenide.open(url);
        } else {
            logger.warn("URL по умолчанию не задан. Переопределите метод getDefaultUrl() в классе страницы.");
        }
    }

    // Абстрактный метод для получения URL страницы
    protected abstract String getDefaultUrl();
}
