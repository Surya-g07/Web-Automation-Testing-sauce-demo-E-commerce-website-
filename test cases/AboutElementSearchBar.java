import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AboutElementSearchBar extends Base {
    @Test(priority = 1)
    public void openAboutSection() throws InterruptedException {
        ch.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);

        ch.findElement(By.id("about_sidebar_link")).click();
        Thread.sleep(3000);

        System.out.println("About page opened");
    }

    @Test(priority = 2)
    public void searchBarTest() throws InterruptedException {
        ch.findElement(By.cssSelector(".MuiBox-root.css-1anwfkt")).click();
        Thread.sleep(1000);

        WebElement search = ch.findElement(By.id("search"));

        search.sendKeys("selenium");
        Thread.sleep(1500);
        search.clear();

        search.sendKeys("12345");
        Thread.sleep(1500);
        search.clear();

        search.sendKeys("@#$%");
        Thread.sleep(1500);
        search.clear();

        System.out.println("Search bar tested");
    }
}
