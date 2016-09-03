package aafrikanov.vk.page;

import com.fasterxml.jackson.databind.deser.Deserializers;
import org.openqa.selenium.WebDriver;

/**
 * Created by HomePcAdmin on 21.03.2016.
 */
public class VkBasePage extends BaseHtmlElementsPage {

    protected String  VK_URL_BASE = "http://vk.com/";

    public VkBasePage(WebDriver driver) {
        super(driver);
    }
}
