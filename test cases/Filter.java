import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Filter extends Base {
    @Test(priority=1)
    public void filterWithAlphs() throws InterruptedException{
        System.out.println("Test case: Verifies the filter section based on the criteria");

        WebElement filter = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container"))
        );

        Select s = new Select(filter);
        Thread.sleep(2000);
        s.selectByVisibleText("Name (Z to A)");
        Thread.sleep(2000);

        WebElement filterAfter = ch.findElement(By.className("product_sort_container"));
        String text = new Select(filterAfter).getFirstSelectedOption().getText();

        if(text.equals("Name (Z to A)")) {
            System.out.println("Test case passed for 'Z to A'");
        } else {
            System.out.println("Test case fails for name filter");
        }

        Thread.sleep(2000);
    }

    @Test(priority=2)
    public void testWithNums() throws InterruptedException{

        WebElement priceFilter = ch.findElement(By.className("product_sort_container"));
        Select s2 = new Select(priceFilter);
        Thread.sleep(2000);

        s2.selectByVisibleText("Price (low to high)");
        Thread.sleep(2000);

        WebElement aftrpriceFilter = ch.findElement(By.className("product_sort_container"));
        String t = new Select(aftrpriceFilter).getFirstSelectedOption().getText();

        if(t.equals("Price (low to high)")){
            System.out.println("Test case passed for 'low to high'");
        } else {
            System.out.println("Test case fails for price filter");
        }

    }
}
