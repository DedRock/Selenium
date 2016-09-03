package aafrikanov.vk.page;

import aafrikanov.vk.block.Dialog;
import aafrikanov.vk.utils.AllureUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Администратор on 19.03.16.
 */
public class VkMessagesPage extends VkPersonalPage {

    private List<Dialog> dialogs;

    public VkMessagesPage(WebDriver driver) {
        super(driver);
    }



    @Step("Find last message from sender")
    public String getLastSenderMessage(String name){

        // Wait for page load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (dialogs.size() == 0) {
            AllureUtil.log("Dialogs not found");
        } else {
            for (Dialog dialog : dialogs){
                if (dialog.getSenderIdLink().equals(String.format("%s%s", VK_URL_BASE,name))){
                    attachElementImgScreenshot(dialog);
                    String lastSenderMessage = dialog.getSenderLastMessage();
                    AllureUtil.log(String.format("Last sender's message: %s", lastSenderMessage));
                    return lastSenderMessage;
                }
            }
            AllureUtil.log(String.format("Dialog with user (id = %s) not found", name));
        }
        return null;
    }




}
