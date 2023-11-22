package tests.day04_maven.day07_testBaseClass_Dropdown;

import Utilitlies.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
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

public class C01_RadioButton{
  //  Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

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
    public void radioButtonKutuTesti(){
        //  a. Verilen web sayfasına gidin.
        //  https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //  b. Cinsiyet Radio button elementlerini locate edin ve radio buttonu secerek
        //  size uygun olani secin

        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        kadinRadioButton.sendKeys(Keys.SPACE);

        //  c. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assert.assertTrue(kadinRadioButton.isSelected());
        Assert.assertFalse(erkekRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());

        ReusableMethod.bekle(3);
    }
    @Test
    public void radioButtonYaziTesti(){
        //  a. Verilen web sayfasına gidin.
        //  https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //  b. Cinsiyet Radio button elementlerini locate edin ve radio button yazidan
        //  size uygun olani secin

      driver.findElement(By.xpath("//*[@class='container form-container']")).sendKeys(Keys.PAGE_DOWN);
        ReusableMethod.bekle(10);
        WebElement kadinRadioYazi = driver.findElement(By.xpath("//label[text()='Kadın']"));
        //kadinRadioYazi.sendKeys(Keys.PAGE_DOWN);
        kadinRadioYazi.click();

        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));


        //  c. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assert.assertTrue(kadinRadioButton.isSelected());
        Assert.assertFalse(erkekRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());

        ReusableMethod.bekle(3);

    }
}
