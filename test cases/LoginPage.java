import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage{
    WebDriver ch = new ChromeDriver();
    @Test
    public void login()throws InterruptedException{
        ch.get("https://www.saucedemo.com/");
        ch.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        ch.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        ch.findElement(By.id("login-button")).click();
    }
}