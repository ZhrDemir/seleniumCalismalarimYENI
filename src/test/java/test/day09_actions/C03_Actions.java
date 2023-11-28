package test.day09_actions;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Actions extends TestBase {

    @Test
    public void sagCliktesti(){

        // 1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
        ReusableMethod.bekle(1);
       // 2- “DGI Drones” uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement DGIDrons = driver.findElement(By.id("hot-spot"));
        actions.contextClick(DGIDrons).perform();

        ReusableMethod.bekle(2);

       // 3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
         String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
         String actuelAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actuelAlertYazisi);

       // 4- Tamam diyerek alert’i kapatalim
          driver.switchTo().alert().accept();

        ReusableMethod.bekle(5);
    }
}
