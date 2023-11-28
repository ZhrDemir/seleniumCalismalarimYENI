package test.day09_actions;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_DragAngDrop extends TestBase {
    @Test
    public void dragAndDropTesti(){


       // 1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");


       // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement acceptable = driver.findElement(By.id("draggable2"));
        WebElement tasınacakHedefAlan = driver.findElement(By.id("droppable2"));
        ReusableMethod.bekle(2);
        actions.dragAndDrop(acceptable,tasınacakHedefAlan).perform();

        ReusableMethod.bekle(2);


        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedYazi = "Dropped!";
        String actualYazi = tasınacakHedefAlan.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

       // 4- Sayfayi yenileyin
        driver.navigate().refresh();

        ReusableMethod.bekle(3);
       // 5- “Not Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim
        tasınacakHedefAlan = driver.findElement(By.id("droppable2"));

        WebElement notAccepElementi = driver.findElement(By.id("draggable-nonvalid2"));

        actions.dragAndDrop(tasınacakHedefAlan,notAccepElementi).perform();

        ReusableMethod.bekle(4);

       // 6- “Drop Here” yazisinin degismedigini test edin

        expectedYazi = "Drop Here";
        actualYazi = tasınacakHedefAlan.getText();
        Assert.assertEquals(expectedYazi,actualYazi);









    }
}
