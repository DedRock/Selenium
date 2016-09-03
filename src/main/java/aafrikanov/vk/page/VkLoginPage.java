package aafrikanov.vk.page;

import aafrikanov.vk.block.LoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class VkLoginPage extends VkBasePage{

    LoginForm loginForm;

    public VkLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("VK Login")
    public VkFeedPage login(String login, String password) {
        this.loginForm.login(login, password);
        return new VkFeedPage(getDriver());
    }


}
