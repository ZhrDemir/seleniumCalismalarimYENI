package test.day10_actions_faker_fileTestleri;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesExistsTesti extends TestBase {
    @Test
    public void dosyaIndirmeTesti(){


      // 2. https://the-internet.herokuapp.com/download adresine gidelim.
       driver.get("https://the-internet.herokuapp.com/download");

      // 3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();

        ReusableMethod.bekle(2);

      // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu="C:/Users/AİLE/Downloads/logo.png";


        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }


}
