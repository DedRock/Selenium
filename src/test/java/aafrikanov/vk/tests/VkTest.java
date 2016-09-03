package aafrikanov.vk.tests;

import aafrikanov.vk.page.VkLoginPage;
import aafrikanov.vk.utils.AllureUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Администратор on 19.03.16.
 */
public class VkTest{


    final String TEST_MESSAGE = "Тест";

    private WebDriver driver;
    private Properties settings  = new Properties();;

    private String login;
    private String password;
    private String testVkSenderId;
    private String testVkSenderMessage;

    //String TEST_MESSAGE_SENDER;
    //String TEST_MESSAGE;


    @Before
    public void before() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("settings.properties");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            settings.load(inputStream);
            //in.close();

            login = settings.getProperty("vk.login");
            password = settings.getProperty("vk.password");
            testVkSenderId = settings.getProperty("test.vk.sender.id");
            testVkSenderMessage = settings.getProperty("test.vk.sender.last.message");
        } catch (IOException ioe){
            System.out.print("Test's Settings-file cann't read.");
        }
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Step("Open Vk page")
    private VkLoginPage openVkPage(){
        driver.get("http://www.vk.com");
        return new VkLoginPage(driver);
    }


    @Title("Check incomming message")
    @Test
    public void checkIncomingMessage() {
        VkLoginPage loginPage = openVkPage();
        /*
        String lastSenderMessage = loginPage.login(login, password).selectMessagesMenuItem().getLastSenderMessage(testVkSenderId);
        Assert.assertNotNull("Messages from sender not found.", lastSenderMessage);
        AllureUtil.log("Check incomming message with test value", "!!!");
        Assert.assertTrue(String.format("Last test message from \"%s\" is not \"%s\", it's : \"\" ", testVkSenderId, TEST_MESSAGE), lastSenderMessage.equals(TEST_MESSAGE));
        */
    }

    @After
    public void closeDriver() {
        if (driver != null){
            driver.quit();
        }
    }
}
