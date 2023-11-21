package tests.day04_maven.day05_JUnitFramework;

import Utilitlies.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_BeforeAfterNotasyonlari {

    WebDriver driver;
    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void driverQuit(){
        driver.quit();
    }


    @Test
    public void wisequarterTest() {



        driver.get("https://www.wisequarter.com");

        // title ın "Wise" içerdiğini test edin

        String expectedTitle = "google";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Wise testi passed");
        } else {
            System.out.println("Wise testi failed");
            throw new AssertionFailedError();
        }


    }
    @Test @Ignore
    public void googleTest(){



        //  google.com a gidin

        driver.get("https://www.google.com");



        // url ın "google" içerdiğini test edin

        String expectedUrl = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Google testi passed");
        }else System.out.println("Google testi failed");


    }
    @Test
    public void testOtomasyonuTest(){


        //testotomasyonu.com a gidin
        driver.get("https://www.testotomasyonu.com");

        // title ın "Test Otomasyon" içerdiğini test edin

        String expectedTitle = "Test Otomasyon";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test Otomasyon testi passed");
        }else System.out.println("Test Otomasyon testi failed");


    }





}



