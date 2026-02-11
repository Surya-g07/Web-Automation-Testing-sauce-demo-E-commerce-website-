import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Reset extends Base {

    @Test(priority = 1)
    public void reset() throws InterruptedException {
        System.out.println("Test case: Ensure the reset app button is working properly");

        WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        String ct = cart.getText();
        cart.click();
        System.out.println("Element added to cart");
        Thread.sleep(2000);

        WebElement nav = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
        nav.click();
        System.out.println("Navigation menu opens");
        Thread.sleep(2000);

        WebElement resetbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reset_sidebar_link")));
        resetbtn.click();
        System.out.println("Reset app state clicked");
        Thread.sleep(2000);

        WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-cross-btn")));
        close.click();
        Thread.sleep(2000);

        System.out.println("Checking that the app state is reset to default");

        WebElement addBtnAftrRst = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack")));
        String text = addBtnAftrRst.getText();
        Assert.assertEquals(text, ct, "App state reset fails");
    }
}
