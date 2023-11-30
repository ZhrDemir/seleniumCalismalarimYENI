package test.day11_weets_cookies;

import Utilitlies.ReusableMethod;
import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C03_cookies extends TestBase {

 @Test
    public void cookitestleri(){

    //  1- Amazon anasayfaya gidin
     driver.get("https://www.amazon.com");

    //  2- tum cookie’leri listeleyin
      Set<org.openqa.selenium.Cookie> cookiesSeti = driver.manage().getCookies();

     int siraNo = 1;
     for (Cookie each : cookiesSeti
          ) {
         System.out.println((siraNo + "====> " + each));
         siraNo++;
     }

    //  3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
     int expectedMinCookieSayi = 5;
     int actualCookieSayi = cookiesSeti.size();
     Assert.assertFalse(actualCookieSayi>expectedMinCookieSayi);

    //  4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

     String expectedCookieValu = "USD";
     String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
     Assert.assertEquals(expectedCookieValu,actualCookieValue);

    //  5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
     //  olusturun ve sayfaya ekleyin
     Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
     driver.manage().addCookie(yeniCookie);


    //  6- eklediginiz cookie’nin sayfaya eklendigini test edin
cookiesSeti = driver.manage().getCookies();

siraNo = 1;
     for (Cookie each: cookiesSeti
          ) {
         System.out.println(siraNo +"=====> " + each);
         siraNo++;
     }
     expectedCookieValu = "cikolatali";
     actualCookieValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
     Assert.assertEquals(expectedCookieValu,actualCookieValue);

    //  7- ismi skin olan cookie’yi silin ve silindigini test edin
     System.out.println(driver.manage().getCookieNamed("Böyle bir cookie yok"));
     driver.manage().getCookieNamed("skin");
     Assert.assertFalse(driver.manage().getCookieNamed("skin")==null);

    //  8- tum cookie’leri silin ve silindigini test edin
      driver.manage().deleteAllCookies();
      cookiesSeti = driver.manage().getCookies();
      Assert.assertTrue(cookiesSeti.size()==0);

     ReusableMethod.bekle(3);



 }


}
