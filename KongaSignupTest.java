import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class KongaSignupTest {

   private WebDriver driver;

    @Test
   public void start () throws InterruptedException {
         System.setProperty("webdriver.chrome.driver", "Resources/chromedriver_win32 (1)");
         driver.new.ChromeDriver();
         driver.get("https://www.konga.com/");
         Thread.sleep(5000);

         driver.manage().window().maximize();
         driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[3]/div/a")).click();
         driver.findElement(By.id("user_first name")).sendKeys("coderiyanu");
         driver.findElement(By.id("user_last name")).sendKeys("Babayemi");
         driver.findElement(By.id("user_email address")).sendKeys("iyanu@mailnator.com");
         driver.findElement(By.id("user_phone number")).sendKeys("09065853577");
         driver.findElement(By.id("user_password")).sendKeys("admin2022");
         driver.findElement(By.id("create an account")).click();

         Thread.sleep(5000);
         driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div/div[2]/a")).click();

         Thread.sleep(5000);
         driver.findElement(By.id("user_email address")).sendKeys("iyanu@mailnator.com");
         driver.findElement(By.id("user_password")).sendKeys("admin2022");
         driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div/div[1]/form/div[3]/button")).click();
    }
        public void CloseBrowser () {
        @AfterTest
        driver.quit();
    }
}
