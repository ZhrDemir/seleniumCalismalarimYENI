package test.day04_maven.day08_iFrame_cok;

import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

public class C05_KontrolluCokluWindoeCalişmalari extends TestBase {


    @Test
public void test01() {
// Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

// url'in testotomasyonu icerdigini test edin
        String expectedURLIcerik="testotomasyonu";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURLIcerik));

// yeni bir tab olarak elctronics linkini acin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();

// acilan sayfanin electronics sayfasi oldugunu test edin
        String expectedTitleIcerik = "Elektronics";
        String actualTitleIcerik = driver.getTitle();
        Assert.assertTrue(actualTitleIcerik.contains(expectedTitleIcerik));

// yeni bir window'da acilacak sekilde menfashion linkini tiklayin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.testotomasyonu.com");
       // driver.findElement(By.xpath((//)))

// menfashion sayfasinin acildigini test edin

// ilk actigimiz sayfaya donun

// test otomasyon anasayfada oldugumuzu test edin


    }




}
