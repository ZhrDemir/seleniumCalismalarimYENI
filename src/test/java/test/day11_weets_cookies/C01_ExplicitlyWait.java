package test.day11_weets_cookies;

import Utilitlies.ReusableMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait {

// 1. Bir class olusturun : WaitTest
// 2. Iki tane metod olusturun : implicitWait() , explicitWait()
//     Iki metod icin de asagidaki adimlari test edin.
// 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
// 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
// 6. Add buttonuna basin
// 7. It’s back mesajinin gorundugunu test edin
@Test
    public void implicitlyWaitTesti(){

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    // 4. Remove butonuna basin.
    driver.findElement(By.xpath("//*[text()='Remove']")).click();

    // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    WebElement itsGoneElementi = driver.findElement(By.id("message"));
    Assert.assertTrue(itsGoneElementi.isDisplayed());

    // 6. Add buttonuna basin
    driver.findElement(By.xpath("//*[text()='Add']")).click();

    // 7. It’s back mesajinin gorundugunu test edin
    WebElement itsBackElementi = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
    Assert.assertTrue(itsBackElementi.isDisplayed());

    ReusableMethod.bekle(5);
    driver.quit();






}
@Test

public void explicitlyWaitTesti() {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();


    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    // 4. Remove butonuna basin.
    driver.findElement(By.xpath("//*[text()='Remove']")).click();

    // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
    Assert.assertTrue(itsGoneElementi.isDisplayed());

    // 6. Add buttonuna basin
    driver.findElement(By.xpath("//*[text()='Add']")).click();

    // 7. It’s back mesajinin gorundugunu test edin
    WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
    Assert.assertTrue(itsBackElementi.isDisplayed());


}
}
