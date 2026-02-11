import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Base {

    protected static WebDriver ch;
    protected static WebDriverWait wait;

    @BeforeSuite
    public void setupSuite() {
        ChromeOptions opt = new ChromeOptions(); 
        Map<String, Object> prefs = new HashMap<>(); 
        prefs.put("-credential_enable_service", false); 
        prefs.put("profile.password_manager_enabled", false);
        opt.setExperimentalOption("prefs", prefs);
        opt.addArguments("--disable-blink-features=AutomationControlled"); 
        opt.addArguments("--disable-save-password-bubble"); 
        opt.addArguments("--incognito");

        ch = new ChromeDriver(opt);
        ch.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(ch, Duration.ofSeconds(10));

        System.out.println("Browser started");
    }

    @BeforeClass
    public void loginOnce() throws InterruptedException {
        ch.get("https://www.saucedemo.com/");
        ch.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        ch.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        ch.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        System.out.println("Login done ONCE");
    }

    @AfterSuite
    public void closeBrowser() {
        ch.quit();
        System.out.println("Browser closed");
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                File src = ((TakesScreenshot) ch).getScreenshotAs(OutputType.FILE);
                File dest = new File("screenshots/" + result.getName() + ".png");
                FileUtils.copyFile(src, dest);
                System.out.println("Screenshot saved for failed test: " + result.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

