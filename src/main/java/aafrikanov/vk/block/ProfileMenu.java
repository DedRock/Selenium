package aafrikanov.vk.block;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;

@Name("Vk Profile Menu")
@FindBy(id="side_bar")
public class ProfileMenu extends HtmlElement{

    @FindBy(css="#l_msg a.left_row")
    Link messagesLink;


    public void selectMessagesMenuItem(){
        messagesLink.click();
    }
}
