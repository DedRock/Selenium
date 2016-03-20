package aafrikanov.vk.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 19.03.16.
 */
public class VkMessagesPage extends VkPersonalPage {

    String  VK_URL_BASE = "http://vk.com/";

    //@FindBy(id="im_dialogs")
    //WebElement messages;

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

        /*
        List<WebElement> dialogs =  getDriver().findElements(By.cssSelector("table.dialogs_row_t"));
        if (dialogs.size() != 0){
            for (WebElement dialog : dialogs){
                if (dialog.findElement(By.cssSelector(".dialogs_user a")).getText().equals(name)){
                    try {
                        attachElementImgScreenshot(dialog);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return dialog.findElement(By.className("dialogs_msg_text")).getText();
                }
            }
        }
        return null;
        */
        List<WebElement> dialogs =  getDriver().findElements(By.cssSelector("table.dialogs_row_t"));
        if (dialogs.size() == 0) {
            log("Dialogs not found");
        } else {
            for (WebElement dialog : dialogs){
                WebElement dialogUser = dialog.findElement(By.cssSelector(".dialogs_user a"));
                if (dialogUser.getAttribute("href").equals(String.format("%s%s", VK_URL_BASE,name))){
                    attachElementImgScreenshot(dialog);
                    String lastSenderMessage = dialog.findElement(By.className("dialogs_msg_text")).getText();
                    log(String.format("Last sender's message: %s", lastSenderMessage));
                    return lastSenderMessage;
                }
            }
            log(String.format("Dialog with user (id = %s) not found", name));
        }
        return null;

    }



}
