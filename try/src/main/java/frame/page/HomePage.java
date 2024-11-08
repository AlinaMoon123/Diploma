package frame.page;

public class HomePage extends BasePage<HomePage> {
    private static final String PAGE_TYPE = "home";  // Тип страницы для идентификации элемента

    // Конструктор для HomePage
    public HomePage() {
        super(HomePage.class, PAGE_TYPE);
    }

    // Переопределение метода для получения URL
    @Override
    protected String getDefaultUrl() {
        return "https://www.ozon.ru";
    }
}
