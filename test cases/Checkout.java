import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Checkout extends Base {

    Scanner sc = new Scanner(System.in);
    int n;
    @Test(priority = 1)
    public void shopping() throws InterruptedException {
        System.out.println("Test case : Check the shopping section whether the product is successfully ordered or not");

        WebElement crtbtn = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));

        crtbtn.click();
        Thread.sleep(2000);
        System.out.println("Add to cart button is executed successfully and product added");

        ch.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        String text = ch.findElement(By.className("shopping_cart_badge")).getText();
        n = Integer.parseInt(text);

        ch.findElement(By.id("checkout")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void checkout() throws InterruptedException {
        System.out.println("Moves to information details page");

        System.out.println("Enter the FirstName");
        ch.findElement(By.id("first-name")).sendKeys(sc.next());
        Thread.sleep(1000);

        System.out.println("Enter the LastName");
        ch.findElement(By.id("last-name")).sendKeys(sc.next());
        Thread.sleep(1000);

        System.out.println("Enter the Pincode");
        ch.findElement(By.id("postal-code")).sendKeys(sc.next());
        Thread.sleep(2000);

        System.out.println("Customer details entered.");
        ch.findElement(By.id("continue")).click();
        Thread.sleep(2000);

        System.out.println("Moves to final overview page");
        System.out.println("Total number of items is listed : " + n);

        ch.findElement(By.id("finish")).click();
        System.out.println("Finish button clicked and order completed");

        String header = ch.findElement(By.className("complete-header")).getText();
        String body = ch.findElement(By.className("complete-text")).getText();

        System.out.println(
                "Order completed Successfully and message displayed as : "
                        + header + " and " + body);

        ch.findElement(By.id("back-to-products")).click();
        System.out.println("Return back to home page");
    }
}
