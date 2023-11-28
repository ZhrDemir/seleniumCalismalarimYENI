package test.day09_actions;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_Odev2 extends TestBase {


    // icinde oldugumuz sayfa ve driver'i input olarak alip
    // ikinci sayfa Window Handle Degerini bize donduren
    // bir method kullanalim

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        String ilkSayfaWhd= driver.getWindowHandle();
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h2"));
        String expectedYazi = "Add/Remove Elements";
        String actualYazi = yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //● ’Please click for Electronics Products’ linkine tiklayin.
        ReusableMethod.bekle(2);
        driver.findElement(By.linkText("Electronics Products")).click();
        //● Electronics sayfasinin acildigini test edin

        String ikinciWhd = ReusableMethod.ilkSayfaWhdIleIkinciSayfaWhdBul(driver,ilkSayfaWhd);
        driver.switchTo().window(ikinciWhd);

        //● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        String sonucSayisiStr = sonucYaziElementi.getText().replaceAll("\\D","");// "16"
        int actualSonucSayisi = Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi = 16;

        Assert.assertEquals(expectedSonucSayisi,actualSonucSayisi);
        ReusableMethod.bekle(2);
        //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkSayfaWhd);
        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethod.bekle(2);
    }


}
