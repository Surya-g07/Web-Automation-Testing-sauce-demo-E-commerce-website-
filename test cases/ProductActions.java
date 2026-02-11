import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ProductActions extends Base{

        @Test(priority=1)
        public void test() throws InterruptedException{
            System.out.println("Test case: Test the product is clickable and moves to certain page");
            String homeurl = ch.getCurrentUrl();
            Thread.sleep(2000);

            Actions act = new Actions(ch);
            act.moveToElement(ch.findElement(By.className("inventory_item_name"))).perform();
            System.out.println("The product is highlighted when mousehover");
            Thread.sleep(2000);

            ch.findElement(By.className("inventory_item_name")).click();
            String producturl = ch.getCurrentUrl();
            System.out.println("Test case : Test the product purchasing by clicking that product");
            
            if(!producturl.equals(homeurl)){
                System.out.println("Test passed : Action performed");
            }
            else{
                System.out.println("Test case fails");
            }
            
        
        }

}