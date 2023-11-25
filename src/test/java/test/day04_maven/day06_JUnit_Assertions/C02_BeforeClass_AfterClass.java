package test.day04_maven.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClass_AfterClass {


    // 3 farklı test methodu oluşturarak

    //aşağıda verilen görevi tamamlayın

    //1. testotomasyon sayfasına gidin

    // url in testotomasyonu içerdiğini test edin

    //2. phone için arama yaptırın

    // ve arama sonucunda urun bulunabildiğini test edin

    //3- ilk urun tıklayın
    // ve urun acıklamasına case sensitive olmadan phone geçtiğini test edin


    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterClass
    public static void teardown(){
        driver.quit();

    }


    @Test
    public void test01(){
        //url testi
        driver.get("https://www.testotomasyonu.com");
        String expectedUrl ="testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url testi FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test02(){
        //arama testi
       WebElement aramaKutusu= driver.findElement(By.id("global-search"));
       aramaKutusu.sendKeys("phone"+ Keys.ENTER);
       WebElement aramaSonucu = driver.findElement(By.className("product-count-text"));
       String aramaSonucSayısıStr = aramaSonucu.getText().replaceAll("\\D","");
       int aramaSonucSayisi = Integer.parseInt(aramaSonucSayısıStr);

       if (aramaSonucSayisi>0){
           System.out.println("Arama sonuc testi PASSED");

       }else {
           System.out.println("Arama sonucu testi Failed");
           throw new AssertionFailedError();
       }


    }

    @Test
    public void test03(){

        // ilk urun detay testi
        // 3- ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();
        //    ve urun aciklamasinda case sensitive olmadan phone gectigini test edin
        WebElement urunAciklamaElementi = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String expectedUrunIcerik = "phone";
        String urunAciklama = urunAciklamaElementi.getText().toLowerCase();

        if (urunAciklama.contains(expectedUrunIcerik)){
            System.out.println("Ilk urun testi PASSED");
        }else {
            System.out.println("Ilk urun testi FAILED");
            throw new AssertionFailedError();
        }

    }











}
