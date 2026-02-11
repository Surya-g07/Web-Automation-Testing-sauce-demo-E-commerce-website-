import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Shopping extends Base {

    @Test(priority = 1)
    public void shoppingTest() throws InterruptedException{
        System.out.println("Test case: Verifies the shopping section");
        Thread.sleep(2000);

        WebElement crtbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("add-to-cart-sauce-labs-backpack")));
        crtbtn.click();
        Thread.sleep(2000);
        System.out.println("Add to cart button executed successfully");

        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("shopping_cart_link")));
        icon.click();
        Thread.sleep(2000);
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("shopping_cart_badge")));
        int n = Integer.parseInt(badge.getText());
        if (n > 0) {
            System.out.println("Product added to cart, cart badge changed to " + n);
        } else {
            System.out.println("Test case fails: cart badge not updated");
        }

        WebElement shoppingBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("continue-shopping")));
        shoppingBtn.click();
        Thread.sleep(2000);
        System.out.println("Continue shopping executed after adding one item");

        WebElement addMoreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("add-to-cart-sauce-labs-bike-light")));
        addMoreElement.click();
        Thread.sleep(2000);
        System.out.println("Extra product added to cart");

        WebElement finalcrtbadge = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("shopping_cart_badge")));
        int num = Integer.parseInt(finalcrtbadge.getText());
        Thread.sleep(2000);
        if (num > 0) {
            WebElement finalicon = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("shopping_cart_link")));
            finalicon.click();
            System.out.println("Test case passed: Multiple products added to cart and able to shop frequently");
        } else {
            System.out.println("Test case fails in the continue shopping area");
        }
    }
}
