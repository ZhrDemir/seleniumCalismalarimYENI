package test.day10_actions_faker_fileTestleri;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_ActionsAsagıyaInme extends TestBase {
    @Test
    public void test01(){


       // 2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

       // 3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethod.bekle(2);

        // 4- videoyu izlemek icin Play tusuna basin

        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeElementi);
        ReusableMethod.bekle(2);
        driver.findElement(By.xpath("//*[@*='ytp-play-button ytp-button']"));

       // 5- videoyu calistirdiginizi test edin








    }
}
