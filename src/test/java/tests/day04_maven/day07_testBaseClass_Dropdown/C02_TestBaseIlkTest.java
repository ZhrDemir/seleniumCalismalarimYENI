package tests.day04_maven.day07_testBaseClass_Dropdown;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C02_TestBaseIlkTest extends TestBase {
    @Test
    public void aramaTesti(){
        //testotomasyonu.com a gidin
        driver.get("https://www.testotomasyonu.com");

        //phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //arama sonucunda urun bulunabildiğini test edin
        WebElement aramaSonucElementi =driver.findElement(By.className("product-count-text"));
        String aramasonucuStr= aramaSonucElementi.getText().replaceAll("\\D","");
        int aramasonucuSayisi = Integer.parseInt(aramasonucuStr);
        Assert.assertTrue(aramasonucuSayisi>0);
        ReusableMethod.bekle(2);


    }


}
