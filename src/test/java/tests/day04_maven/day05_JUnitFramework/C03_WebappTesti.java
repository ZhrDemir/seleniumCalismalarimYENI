package tests.day04_maven.day05_JUnitFramework;

import Utilitlies.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebappTesti {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

     //  1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

     //  2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

     //  3. Login alanine  “username” yazdirin
        WebElement loginKutusu = driver.findElement(By.id("user_login"));
        loginKutusu.sendKeys("username");

     //  4. Password alanina “password” yazdirin
        WebElement paswordKutusu = driver.findElement(By.id("user_password"));
        paswordKutusu.sendKeys("password");

     //  5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@*='Sign in']")).click();


        //  6. Back tusu ile sayfaya donun
        driver.navigate().back();

     //  7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();


     //  8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amaonKutusu = driver.findElement(By.id("sp_amount"));
        amaonKutusu.sendKeys("100");
        ReusableMethod.bekle(3);

     //  9. tarih kismina “2023-09-10” yazdirin
      driver.findElement(By.id("sp_date")).sendKeys("2023-09-10");
      ReusableMethod.bekle(3);

        //  10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();


     //  11. “The payment was successfully submitted.” mesajinin ciktigini test edin

        WebElement mesajElementi = driver.findElement(By.id("alert_content"));

        String expectedResult = "The payment was successfully submitted.";
        String actualResultYazisi = mesajElementi.getText();

        if (actualResultYazisi.equals(expectedResult)){
            System.out.println("Mesaj testi PASSED");
        }else   System.out.println("Mesaj testi FAILED");

        ReusableMethod.bekle(2);
        driver.quit();

    }
}
