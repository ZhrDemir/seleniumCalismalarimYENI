package tests.day04_maven.day05_JUnitFramework;

import Utilitlies.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_MethodIleDriverOlusturma {

    WebDriver driver;
    public void setup(){

       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void wisequarterTest(){

        setup();

     driver.get("https://www.wisequarter.com");

        // title ın "Wise" içerdiğini test edin

        String expectedTitle = "Wise";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Wise testi passed");
        }else System.out.println("Wise testi failed");

        ReusableMethod.bekle(5);
        driver.quit();

    }






}
