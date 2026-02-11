import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Buttons extends Base {

    @Test
    public void loginButtonTest() {
        WebElement button =
                wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));

        Assert.assertTrue(button.isDisplayed(), "Login button not displayed");
        Assert.assertTrue(button.isEnabled(), "Login button not enabled");

        System.out.println("Login button is enabled and displayed");
    }
}
