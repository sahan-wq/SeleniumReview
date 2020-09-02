import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Day02_Xpath {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.get("http://a.testaddressbook.com/");
        //<a id="sign-in" class="nav-item nav-link" data-test="sign-in"
        // href="/sign_in">Sign in</a>
        // id               EVET, className        HAYIR, tagName          EVET, name             HAYIR, xpath            EVET, cssSelector      EVET, linkText         EVET, partialLinkText  EVET
        WebElement signInLinki = driver.findElement(By.linkText("Sign in"));
        signInLinki.click();
        //  ipucu : findElements kullanabilirsiniz.
        //  ipucu : tagName'i a olan webelementler linktir.
        //  ipucu : bir sayfadaki tüm webelementleri bulmak istiyorsanız, findElements
        //          kullanabilirsiniz.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        List<WebElement> tumLinkler = driver.findElements(By.tagName("a"));
        //By.xpath("//a")
        for(WebElement w : tumLinkler){
            System.out.println(w.getText());
        }
        WebElement email = driver.findElement(By.cssSelector(".form-control"));
        email.sendKeys("testtechproed@gmail.com");

        WebElement pass= driver.findElement(By.cssSelector("#session_password"));
        pass.sendKeys("Test1234!");
        WebElement giris= driver.findElement(By.cssSelector(".btn.btn-primary"));
        giris.click();

        //xpath "//*" den sonra yazilirsa tum elemenletleri alir
//        List<WebElement> tumElementler = driver.findElements(By.xpath("//*"));
//
//        for (WebElement w: tumElementler ) {
//            System.out.println(w.getText());
//
//        }
        WebElement tumYazilar = driver.findElement(By.tagName("body"));
        System.out.println(tumYazilar.getText());



    }
    @AfterClass
    public static void tearDown(){
        // driver.quit();
    }
}