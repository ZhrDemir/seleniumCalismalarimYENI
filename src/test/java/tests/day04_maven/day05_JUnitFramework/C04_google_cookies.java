package tests.day04_maven.day05_JUnitFramework;

import Utilitlies.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_google_cookies {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // 2- https://www.google.com/ adresine gidin

        driver.get("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek kapatin



      // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedTitleIcerik = "Google";
        String actualTitleIcerik = driver.getTitle();

        if (actualTitleIcerik.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");

      // 5- Arama cubuguna “Nutella” yazip aratin

        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

      // 6- Bulunan sonuc sayisini yazdirin

        WebElement sonucYazdir = driver.findElement(By.id("result-stats"));
        String sonucYazisiStr = sonucYazdir.getText();
        System.out.println("Bulunan sonuc yazısı : "+sonucYazisiStr);


      // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String[] sonucYazisiArr = sonucYazisiStr.split(" ");

        String sonucSayısıStr = sonucYazisiArr[1];

        sonucSayısıStr = sonucSayısıStr.replaceAll("\\D","");
        int sonucSayisiInt = Integer.parseInt(sonucSayısıStr);

        if (sonucSayisiInt > 10000000){
            System.out.println("Arama sonuc sayısı testi PASSED");
        }else System.out.println("Arama sonuc sayısı testi Failed");

      // 8- Sayfayi kapatin

        ReusableMethod.bekle(5);
        driver.quit();

    }
}
