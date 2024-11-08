package frame.element;

public class Button extends BaseElement {

    public Button(String locator) {
        super(locator);
    }

    public String getButtonText() {
        return getText();
    }
}
