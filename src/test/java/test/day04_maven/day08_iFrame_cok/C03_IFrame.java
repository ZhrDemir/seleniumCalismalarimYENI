package test.day04_maven.day08_iFrame_cok;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C03_IFrame extends TestBase {

    @Test
    public void test01(){

      // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");


      // 2) cookies kabul edin
      // 3) sayfadaki iframe sayısını bulunuz.

        List<WebElement> iFrameList = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayısı : " + iFrameList.size());
        ReusableMethod.bekle(3);

        // 4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iframeYouTubeElementi = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(iframeYouTubeElementi);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

      // 5) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        iframeYouTubeElementi.sendKeys(Keys.PAGE_DOWN);
        iframeYouTubeElementi.sendKeys(Keys.PAGE_DOWN);
        iframeYouTubeElementi.sendKeys(Keys.PAGE_DOWN);
        iframeYouTubeElementi.sendKeys(Keys.PAGE_DOWN);

      // 6) ikinci iframe'deki (Jmeter Made Easy) linke

        // (https://www.guru99.com/live-selenium-project.html) tıklayınız

        WebElement JmeterIFrame = driver.findElement(By.xpath("(//iframe)[6]"));
        driver.switchTo().frame(JmeterIFrame);

        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();





    }




}
