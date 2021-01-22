import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class syncseven {


    public static WebDriver driver;
    static String BaseURL = "http://118.179.157.122:9999/account/signin";


    @BeforeTest
    public static void Websetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",  "G:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test (priority = 0)
    public static void Login() throws InterruptedException {
        //Login
        driver.findElement(By.xpath("//input[@id='UserName']")).click();
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("shahid@redlimesolutions.com");
        Thread.sleep(2000);
        //Password
        driver.findElement(By.xpath("//input[@id='Password']")).click();
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
        //Signin_Now
        driver.findElement(By.xpath("//button[@id='btnSignIn']")).click();
        Thread.sleep(2000);
        //Today_Res
        driver.findElement(By.xpath("//a[@id='aToday']")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 1)
    public static void Logout() throws InterruptedException {
        //Logout
        driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[9]/a[1]/i[1]")).click();
        Thread.sleep(10000);
    }

    @AfterTest
    public static void Test_Closure() {
        driver.quit();
    }


}
