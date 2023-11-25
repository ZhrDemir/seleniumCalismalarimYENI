package test.day04_maven.day05_JUnitFramework;

import Utilitlies.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_MavenTekrarTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //   1. “https://www.saucedemo.com” Adresine gidin

        driver.get("https://www.saucedemo.com");

        //  2. Username kutusuna “standard_user” yazdirin

        driver.findElement(By.id("user-name")).sendKeys("standard_user"+ Keys.ENTER);


     //  3. Password kutusuna “secret_sauce” yazdirin

        driver.findElement(By.id("password")).sendKeys("secret_sauce"+Keys.ENTER);

     //  4. Login tusuna basin

        driver.findElement(By.id("login-button")).click();

     //  5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

       WebElement ilkUrunISmi =  driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[1]"));
       ilkUrunISmi.click();


        //  6. Add to Cart butonuna basin

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).sendKeys(Keys.ENTER);

     //  7. Alisveris sepetine tiklayin

        driver.findElement(By.className("shopping_cart_link")).click();

     //  8. Sectiginiz urunun basarili olarak sepete eklendigini control edin


        //  9. Sayfayi kapatin
        ReusableMethod.bekle(4);
        driver.quit();

    }
}
