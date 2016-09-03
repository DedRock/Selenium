package aafrikanov.vk.block;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(className = "dialogs_row_t")
public class Dialog extends HtmlElement {

    @FindBy(css = ".dialogs_user a")
    private WebElement senderLink;

    @FindBy(className = "dialogs_msg_text")
    private WebElement messageText;

    public String getSenderLastMessage(){
        return messageText.getText();
    }

    public String getSenderIdLink(){
        return senderLink.getAttribute("href");
    }


}
