package aafrikanov.vk.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Администратор on 19.03.16.
 */
public class BaseHtmlElementsPage {

    private WebDriver driver;

    public BaseHtmlElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void waitForFullPageLoad(){
        new WebDriverWait(getDriver(), 10).until(new ExpectedCondition<Boolean>(){

            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachElementImgScreenshot(WebElement element){
        try {
        BufferedImage image = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, element).getImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        baos.flush();
        byte[] imageInBytes = baos.toByteArray();
        baos.close();
        return imageInBytes;
        } catch (IOException e) {
            return new byte[0];
        }
    }
}
