package test.day04_maven.day08_iFrame_cok;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_IFrame extends TestBase {

    @Test
    public void test01() {

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        //         - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //            konsolda yazdirin.
        WebElement anIFrameYaziElementi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(anIFrameYaziElementi.isEnabled());
        System.out.println(anIFrameYaziElementi.getText());


        //         - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeElem = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElem);



        WebElement textBoxYaziTesti = driver.findElement(By.id("tinymce"));
        textBoxYaziTesti.clear();
        textBoxYaziTesti.sendKeys("Merhaba Dunya!");
        driver.switchTo().parentFrame();

        //         - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin

        //            gorunur oldugunu dogrulayin ve konsolda yazdirin

        WebElement elemantelSelElem = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elemantelSelElem.isDisplayed());


        ReusableMethod.bekle(5);
    }


    }








