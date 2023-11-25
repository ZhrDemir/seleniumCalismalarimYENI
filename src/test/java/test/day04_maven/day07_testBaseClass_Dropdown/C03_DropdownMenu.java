package test.day04_maven.day07_testBaseClass_Dropdown;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C03_DropdownMenu extends TestBase {

    @Test
    public void dropdownTesti() {



//    https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        // 1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        WebElement dogumGunuDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select selectGun = new Select(dogumGunuDdm);
        selectGun.selectByIndex(5);

        // 2. Dogum tarihi ay seçeneğinden visibleText kullanarak Nisan’i secin
        WebElement ayDm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDm);
        selectAy.selectByVisibleText("Nisan");

        // 3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDm);
        selectYil.selectByVisibleText("1990");

        //4. Secilen değerleri konsolda yazdırın
        System.out.println("Seçilen Tarih: " + selectGun.getFirstSelectedOption().getText() +
                                          " "   + selectAy.getFirstSelectedOption().getText() +
                                           " "  + selectYil.getFirstSelectedOption().getText());

        // 5. Ay dropdown menüdeki tum değerleri(value) yazdırın
          List<WebElement> ayOpsiyonElemList = selectAy.getOptions();
        System.out.println(ReusableMethod.stringListeDonustur(ayOpsiyonElemList));

        // 6. Ay Dropdown menusunun boyutunun 30 olduğunu test edin
        Assert.assertEquals(30,ayOpsiyonElemList.size());

        ReusableMethod.bekle(2);
    }
}
