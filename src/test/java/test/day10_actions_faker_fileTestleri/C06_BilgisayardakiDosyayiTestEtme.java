package test.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_BilgisayardakiDosyayiTestEtme {
    @Test
    public void test01(){

        // Downlouds da logo.png old test edin

        String dosyaYolu = "C:\\Users\\AİLE\\Downloads\\logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        String dinamikdosyaYolu = System.getProperty("user.home")+
                "\\Downloads\\logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dinamikdosyaYolu)));





    }
}
