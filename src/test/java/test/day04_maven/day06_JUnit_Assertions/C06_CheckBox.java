package test.day04_maven.day06_JUnit_Assertions;



import Utilitlies.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

    public class C06_CheckBox {


        WebDriver driver;

        @Before
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @After
        public void teardown(){
            driver.quit();
        }

        @Test
        public void checkboxTesti(){
            //	a. Verilen web sayfasına gidin.
            //	     https://testotomasyonu.com/form
            driver.get("https://testotomasyonu.com/form");
            //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
           WebElement sirtAgrisiCheckBox = driver.findElement(By.id("gridCheck5"));
            WebElement sirtYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck5']"));


           sirtAgrisiCheckBox.sendKeys(Keys.SPACE);
           sirtAgrisiCheckBox.sendKeys(Keys.PAGE_DOWN);
            //sirtYaziElementi.;


            WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));

            carpintiCheckBox.sendKeys(Keys.SPACE);
            ReusableMethod.bekle(2);
            //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili
            //  	olduğunu test edin
            Assert.assertTrue(sirtAgrisiCheckBox.isSelected());
            Assert.assertTrue(carpintiCheckBox.isSelected());

           // carpintiCheckBox.sendKeys(Keys.PAGE_DOWN);
            ReusableMethod.bekle(3);
            //	d. Seker ve Epilepsi checkbox’larininin seçili
            //  	olmadigini test edin
            WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
            WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

            Assert.assertFalse(sekerCheckBox.isSelected());
            Assert.assertFalse(epilepsiCheckBox.isSelected());

            ReusableMethod.bekle(3);
        }



}
