package test.day04_maven.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. testotomasyonu.com git
        driver.get("https://www.testotomasyonu.com");

        //2. arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("(//input[@class='search-input'])"));

        //3.phone ile arama yapın
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        //4.Bulunan sonuç sayısını yazdırın

        WebElement sonucYazdir = driver.findElement(By.className("product-count-text"));
        System.out.println(sonucYazdir.getText());

         //5.İlk ürünü tıkla

        driver.findElement(By.xpath("//div[@class='product-box my-2  py-1'][1]")).click();

        //6.Urunun stokta var olduğunu test edin

        WebElement actualStokElementi = driver.findElement(By.xpath("//span[@class='heading-xs ']"));
        String expectedStokta = "Availibility: In Stock";
        String actualStok = actualStokElementi.getText();

        if (expectedStokta.equals(actualStok)){
            System.out.println("Stok Testi PASSED");
        }else System.out.println("Stok testi FAILED");


        Thread.sleep(2000);
        driver.quit();
    }
}
