import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartButton extends Base {
    @Test(priority = 1)
    public void cart() throws InterruptedException{
        WebElement addBtn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("add-to-cart-sauce-labs-backpack")));

        String before = addBtn.getText();
        addBtn.click();
        Thread.sleep(2000);
        WebElement removeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("remove-sauce-labs-backpack")));

        String after = removeBtn.getText();
        Thread.sleep(2000);

        Assert.assertNotEquals(before, after, "Cart button did not change state");
        System.out.println("Test passed");
    }
}
