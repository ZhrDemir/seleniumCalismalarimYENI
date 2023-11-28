package test.day09_actions;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C07_KeyboardActions extends TestBase {

    @Test
    public void test01(){


      // 2- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");


      // 3- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER)
                .perform();
        ReusableMethod.bekle(3);


      // 4- Bulunan urun isminde “DELL Core I3” bulundugunu test edin

        ReusableMethod.bekle(5);

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@*='prod-title mb-3 ']"));

        String expectedYazi = "DELL Core I3";
        String actualYazi = urunIsimElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

    }
}
