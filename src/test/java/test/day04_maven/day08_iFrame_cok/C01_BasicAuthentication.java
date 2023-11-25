package test.day04_maven.day08_iFrame_cok;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C01_BasicAuthentication extends TestBase {



    @Test
    public void BasicAuthentication(){

// 1- Bir class olusturun : BasicAuthentication
// 2- https://testotomasyonu.com/basicauth sayfasina gidin

      driver.get("https://testotomasyonu.com/basicauth");

// 3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
//     Html komutu : https://username:password@URL
//     Username    : membername
//     password     : sunflower

       driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

 // 4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement basariliGirisYaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "Congratulations! You are logged in as: membername";
        String actualYazi = basariliGirisYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethod.bekle(5);
    }









}
