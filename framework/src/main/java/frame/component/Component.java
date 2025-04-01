package frame.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;

public abstract class Component {
    protected SelenideElement element;

    public Component(SelenideElement element) {
        this.element = element;
    }

    public boolean isDisplayed() {
        if (element == null || !element.exists()) {
            return false;
        }
        try {
            element.shouldBe(visible); // Подождет, пока элемент станет видимым
            return true;
        } catch (Exception e) {
            return false; // Если элемент не появился, вернуть false
        }
    }


    public boolean isNotDisplayed() {
        return element == null || !element.exists() || element.shouldBe(hidden).is(visible);
    }

    public SelenideElement getElement() {
        return element;
    }
}


