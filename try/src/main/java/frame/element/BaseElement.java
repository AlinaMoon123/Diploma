package frame.element;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BaseElement {

    protected final SelenideElement element;

    // Конструктор для создания элемента с локатором
    public BaseElement(String locator) {
        this.element = $x(locator);
    }

    // Метод для клика по элементу
    public void click() {
        element.shouldBe(Condition.visible).click();  // Проверяем видимость элемента и кликаем
    }

    // Метод для получения текста элемента
    public String getText() {
        return element.shouldBe(Condition.visible).getText();  // Возвращаем текст элемента
    }

    // Метод для проверки, что элемент видим
    public boolean isVisible() {
        return element.is(Condition.visible);  // Проверяем, что элемент видим
    }

    // Метод для ожидания видимости элемента
    public void waitForVisible() {
        element.shouldBe(Condition.visible);  // Ожидаем, пока элемент станет видимым
    }

    // Метод для получения атрибута элемента
    public String getAttribute(String attribute) {
        return element.getAttribute(attribute);  // Возвращаем атрибут элемента
    }
}
