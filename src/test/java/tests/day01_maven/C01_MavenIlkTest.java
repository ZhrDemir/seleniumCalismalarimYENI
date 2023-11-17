package tests.day01_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {


        /*
        Mahserin dört atlısı ayarları yapardık
        ama bu mecburi değil
        Selenıum 4.8 ayarladığı için webdriver kullanır

         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        //url ın testotomasyonu içerdiğini test et


        Thread.sleep(2000);
        driver.quit();
    }
}
