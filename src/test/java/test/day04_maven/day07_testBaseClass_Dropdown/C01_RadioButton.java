package test.day04_maven.day07_testBaseClass_Dropdown;

import Utilitlies.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
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

        WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"inlineRadio1\"]"));



        //  b. Cinsiyet Radio button elementlerini locate edin ve radio button yazidan
        //  size uygun olani secin


        ReusableMethod.bekle(4);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",radioButton);
        js.executeScript("arguments[0].click();",radioButton);

        ReusableMethod.bekle(3);
        // SORUN!!!!!!
        // GÖRMÜYOR KADIN BUTONUNU O YÜZDEN İŞARETLEYEMİYOR
        // YUKARIDA PAGEDOWN YAPAYIM DEDİM ONU DA YAPMIYOR
        // SAYFA AYARLARIM KOCAMAN OLUYOR SIKINTI ÇIKIYOR ÇOĞU ZAMAN CLİCKLERDE




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
