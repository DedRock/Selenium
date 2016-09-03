package aafrikanov.vk.block;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.*;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;


@Name("Vk Login Form")
@FindBy(id="quick_login")
public class LoginForm extends HtmlElement {

    @FindBy(id="quick_email")
    private TextInput loginTextBox;

    @FindBy(id="quick_pass")
    private TextInput passTextBox;

    @FindBy(id="quick_login_button")
    private Button loginButton;

    public void login(String login, String password){
        loginTextBox.sendKeys(login);
        passTextBox.sendKeys(password);
        loginButton.click();
    }
}
