package test.day09;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C08_KullaniciOlusturma extends TestBase {
    @Test
    public void test01(){


       // 1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        ReusableMethod.bekle(2);
       // 2- Account linkine tiklayin

        driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();

       // 3- Sign Up linkine basalim

        ReusableMethod.bekle(2);
        WebElement signUp = driver.findElement(By.xpath("//*[text()=' Sign Up']"));
        signUp.sendKeys(Keys.PAGE_DOWN);
        ReusableMethod.bekle(2);
        signUp.click();
       // 4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        ReusableMethod.bekle(3);
        WebElement firdtNameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        actions.click(firdtNameKutusu)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("Bulut")
                .sendKeys(Keys.TAB)
                .sendKeys("a@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();

        driver.findElement(By.id("btn-submit-form"));
        ReusableMethod.bekle(3);
       // 5- Kaydin olusturuldugunu test edin



    }
}
