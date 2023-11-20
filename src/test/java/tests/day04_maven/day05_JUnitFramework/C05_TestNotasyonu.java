package tests.day04_maven.day05_JUnitFramework;

import Utilitlies.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_TestNotasyonu {

    @Test
        public void testOtomasyonuTest(){
        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //testotomasyonu.com a gidin
        driver.get("https://www.testotomasyonu.com");

            // title ın "Test Otomasyon" içerdiğini test edin

        String expectedTitle = "Test Otomasyon";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test Otomasyon testi passed");
        }else System.out.println("Test Otomasyon testi failed");

        ReusableMethod.bekle(5);
        driver.quit();

        }

        @Test
        public void wisequarterTest(){

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //  wisequarter.com a gidin

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
@Test
public void googleTest(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //  google.com a gidin

    driver.get("https://www.google.com");



    // url ın "google" içerdiğini test edin

    String expectedUrl = "google";
    String actualUrl = driver.getCurrentUrl();
    if (actualUrl.contains(expectedUrl)){
        System.out.println("Google testi passed");
    }else System.out.println("Google testi failed");

    ReusableMethod.bekle(5);
    driver.quit();


}






}







