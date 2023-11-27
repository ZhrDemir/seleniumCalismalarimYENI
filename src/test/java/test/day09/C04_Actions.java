package test.day09;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_Actions extends TestBase {
    @Test
    public void sagClikTesti(){


      // 2- https://the-internet.herokuapp.com/context_menu sitesine gidin

        driver.get("https://the-internet.herokuapp.com/context_menu");
        ReusableMethod.bekle(2);

      // 3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement cigiliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cigiliAlanElementi).perform();

      // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedAlertYazi = "You selected a context menu";
        String actuelAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazi,actuelAlertYazisi);

      // 5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

      // 6- Elemental Selenium linkine tiklayalim

        driver.findElement(By.linkText("Elemental Selenium")).click();

      // 7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
           ReusableMethod.bekle(1);
           driver = ReusableMethod.titleIleSayfaDegistir(driver,"Elemental Selenium | Elemental Selenium");
           WebElement h1tagYaziElementi = driver.findElement(By.tagName("h1"));

           String expectedYazi = "Make sure your code lands";
           String actualH1Yazi = h1tagYaziElementi.getText() ;
           Assert.assertEquals(expectedYazi,actualH1Yazi);


    }
}
