package aafrikanov.vk.page;

import aafrikanov.vk.block.ProfileMenu;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Администратор on 19.03.16.
 */
public class VkPersonalPage extends BaseHtmlElementsPage{

    ProfileMenu profileMenu;

    public VkPersonalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Go to messsages page")
    public VkMessagesPage selectMessagesMenuItem(){
        profileMenu.selectMessagesMenuItem();
        return new VkMessagesPage(getDriver());
    }
}
