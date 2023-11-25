package test.day04_maven.day07_testBaseClass_Dropdown;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_JavaScriptAlert extends TestBase {



    //  3 test method’u olusturup asagidaki gorevi tamamlayin


    @Test
    public void jsBasicAlert() {

        // 1. Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

//            - 1.alert’e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();


// - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String expectedAlertyazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertyazisi, actualAlertYazisi);

// - OK tusuna basip alert’i kapatin

        ReusableMethod.bekle(3);
        driver.switchTo().alert().accept();
    }
// 2.Test
        @Test
     public void jsConfirmAlert(){
            // - https://testotomasyonu.com/javascriptAlert adresine gidin
            driver.get("https://testotomasyonu.com/javascriptAlert");

//            - 2.alert’e tiklayalim
            driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

// - Cancel’a basip,
 driver.switchTo().alert().dismiss();

// cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin

            WebElement resultYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));

            String expectedResultYazisi = "You clicked: Cancel";
            String actualResultYazisi = resultYaziElementi.getText();

            Assert.assertEquals(expectedResultYazisi,actualResultYazisi);



        }
@Test
    public void jsPromptTesti() {


// 3.Test
// - https://testotomasyonu.com/javascriptAlert adresine gidin
    driver.get("https://testotomasyonu.com/javascriptAlert");
//            - 3.alert’e tiklayalim

    driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

// - Cikan prompt ekranina “Abdullah” yazdiralim
    driver.switchTo().alert().sendKeys("Abdullah");

// - OK tusuna basarak alert’i kapatalim
    driver.switchTo().alert().accept();

// - Cikan sonuc yazisinin Abdullah icerdigini test edelim
    WebElement resultYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));

    String expectedResultYazisi = "Abdullah";
    String actualResultYazisi = resultYaziElementi.getText();

    Assert.assertEquals(expectedResultYazisi,actualResultYazisi);


}
}
