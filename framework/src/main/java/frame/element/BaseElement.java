package frame.element;
import frame.component.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$x;

public class BaseElement extends Component{
    private static final Logger logger = LoggerFactory.getLogger(BaseElement.class);

    public BaseElement(String XPath) {
        super($x(XPath));
        logger.info("Initialized element with XPath: {}", XPath);
    }

    public void focus(){
        element.hover();
    }
}