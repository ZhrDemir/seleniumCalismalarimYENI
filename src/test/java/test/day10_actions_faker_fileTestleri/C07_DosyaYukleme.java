package test.day10_actions_faker_fileTestleri;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C07_DosyaYukleme extends TestBase {

    @Test
    public void dosyaYuklemeTesti(){

      // 1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

      // 2.chooseFile butonuna basalim
        WebElement chooseFileElementi = driver.findElement(By.id("file-upload"));

      // 3.Yuklemek istediginiz dosyayi secelim.
        String dinamikDosyaYolu = System.getProperty("user.home")+
                "\\Downloads\\logo.png";

        chooseFileElementi.sendKeys(dinamikDosyaYolu);

      // 4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

      // 5.“File Uploaded!” textinin goruntulendigini test edelim

        WebElement uplodedYaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "File Uploaded!";

        String actualYazi = uplodedYaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethod.bekle(5);


    }
}
