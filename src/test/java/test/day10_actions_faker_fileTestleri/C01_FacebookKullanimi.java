package test.day10_actions_faker_fileTestleri;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_FacebookKullanimi extends TestBase {

    @Test
    public void test01(){

       // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

       //2- Cookies kabul edin
       //3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@*='open-registration-form-button']")).click();

       //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement firstnameKutusu = driver.findElement(By.xpath("//*[@name='firstname']"));

        Actions actions = new Actions(driver);

        Faker faker = new Faker();
        String email=faker.internet().emailAddress();

        actions.click(firstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("20")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_LEFT)
                .perform();

       //5- Kaydol tusuna basalim

        driver.findElement(By.name("websubmit")).click();

        ReusableMethod.bekle(30);








    }








}
