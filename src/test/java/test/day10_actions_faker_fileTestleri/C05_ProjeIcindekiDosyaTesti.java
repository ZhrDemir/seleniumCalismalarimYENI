package test.day10_actions_faker_fileTestleri;

import Utilitlies.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_ProjeIcindekiDosyaTesti extends TestBase {

    @Test
    public void fileExistsTesti(){

        // projemiz içerisinde day10 package i altında
        // deneme.txt dosyasının olduğunu test edin

        String dosyaYolu = "C:\\Users\\AİLE\\Desktop\\Zehra\\IT\\com.team127_JUnit\\src\\test\\java\\test\\day10_actions_faker_fileTestleri\\deneme.txt";


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        String dinamikDosyaYolu = System.getProperty("user.dir")+"\\src\\test\\java\\test\\day10_actions_faker_fileTestleri\\\\deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));






    }
}
