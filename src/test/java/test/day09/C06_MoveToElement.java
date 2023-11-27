package test.day09;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_MoveToElement extends TestBase {

    @Test
    public void moveToElementTesti(){


       // 1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        ReusableMethod.bekle(2);

       // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin

        WebElement kidsWearElementi=driver.findElement(By.xpath("(//*[@class='has-sub'])[7]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(kidsWearElementi).perform();
        ReusableMethod.bekle(2);

       // 3- “Boys” linkine basin
        WebElement boysLink = driver.findElement(By.xpath("(//ul[@class='submenu-link'])[2]"));
        boysLink.click();

       // 4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//div[@class=‘product-box mb-2 pb-1’])[1]")).click();

       // 4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

        WebElement isimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedIsım = "Boys Shirt White Color";
        String actualIsim = isimElementi.getText();
        Assert.assertEquals(expectedIsım,actualIsim);



    }
}
