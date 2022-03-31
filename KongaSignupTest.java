import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class KongaSignupTest {
    //import selenium driver
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        //locate where your chrome driver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver_win32 (1)/chromedriver.exe");
        //open your chrome driver
        driver = new ChromeDriver();
        //type in url
        driver.get("https://www.konga.com/");
        String expectedurl = "https://www.konga.com";
        String actualurl = driver.getCurrentUrl();
        if (actualurl.contains(expectedurl)) {
            System.out.println("webpage is correct");
        } else {
            System.out.println("webpage is incorrect");
        }
        Thread.sleep(2000);
        //maximize window
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

        //verify that the login button is working, that it opens up the login page
        @Test (priority = 0)
        public void loginButton() throws InterruptedException {
       //click on the login/signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(2000);
        }
        //login with correct email and password
        @Test(priority = 1)
        public void positiveTest() throws InterruptedException {
            //type in the email address
            driver.findElement (By.id("username")).sendKeys("iyanu@mailnator.com");
            //type password
            driver.findElement(By.id("password")).sendKeys("admin2022");
            //copy the xpath for login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(2000);
        }
        //verify the 'My Account' feature is working
        @Test (priority = 2)
        public void myAccount() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
            Thread.sleep(2000);
        }
        //Verify logout button redirects back to the homepage
        @Test(priority = 3)
        public void logOut() throws InterruptedException{
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
            String expectedUrl = "https://www.konga.com";
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.contains(expectedUrl)) {
                System.out.println("webpage is correct");
            } else {
                System.out.println("webpage is incorrect");
                Thread.sleep(2000);
            }
        }
        //Carry out a negative scenario (incorrect password)
        @Test(priority = 4)
        public void Negative() throws InterruptedException{
            //click on the login/signup button
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(2000);
            //type in the email address
            driver.findElement(By.id("username")).sendKeys("iyanu@mailnator.com");
            //type password
            driver.findElement(By.id("password")).sendKeys("admin");
            //copy the xpath for login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).submit();
            Thread.sleep(2000);
        }
        @AfterTest
        public void CloseBrowser() throws InterruptedException {
        //quit the browser
        driver.quit();
        }
    }

