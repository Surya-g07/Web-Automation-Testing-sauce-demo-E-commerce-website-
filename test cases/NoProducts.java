import java.util.*;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NoProducts extends Base{
        Scanner sc = new Scanner(System.in);
        int n = 0;
        // -------- TEST CASE START --------

        @Test(priority=1)
        public void shopping()throws InterruptedException{
            System.out.println("Test: Checkout without adding any product");

            ch.findElement(By.className("shopping_cart_link")).click();
            Thread.sleep(2000);

            ch.findElement(By.id("checkout")).click();
            Thread.sleep(2000);

            System.out.println("Moved to information page");

            System.out.println("Enter First Name:");
            ch.findElement(By.id("first-name")).sendKeys(sc.next());

            System.out.println("Enter Last Name:");
            ch.findElement(By.id("last-name")).sendKeys(sc.next());

            System.out.println("Enter Pincode:");
            ch.findElement(By.id("postal-code")).sendKeys(sc.next());

            Thread.sleep(2000);
            ch.findElement(By.id("continue")).click();
            Thread.sleep(2000);

            System.out.println("Moved to overview page");
        }

        // -------- SAFE CART COUNT CHECK --------

        @Test(priority=2)
            public void checkout() throws InterruptedException {

               List<WebElement> badge = ch.findElements(By.className("shopping_cart_badge"));

                if (!badge.isEmpty()) {
                    n = Integer.parseInt(badge.get(0).getText());
                }

                System.out.println("Cart count detected: " + n);

                ch.findElement(By.id("finish")).click();
                Thread.sleep(2000);

                boolean orderSuccess = ch.getPageSource().contains("Thank you for your order!");

                    // CASE 1: No products added
                    if (n == 0) {
                        Assert.assertFalse(
                            orderSuccess,
                            "DEFECT: Order completed even though cart is empty"
                        );
                        System.out.println("Checkout blocked correctly for empty cart");
                    }
                    // CASE 2: Products added
                    else {
                        Assert.assertTrue(
                                orderSuccess,
                                "Order failed even after adding products"
                        );
                        System.out.println("Order placed successfully");
                        System.out.println("Message: " +
                                ch.findElement(By.className("complete-header")).getText());
                    }
                }
    
}
