import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Can\\Documents\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebookAdd = driver.findElement(By.xpath("//div[2]//a[1]//div[1]//div[2]//button[1]"));
        ebookAdd.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(iFrame1));
        driver.switchTo().frame(iFrame1);

        WebElement removeItem = driver.findElement(By.xpath("//button[@class='Product-Remove']"));
        removeItem.click();

        WebElement continueShoppingButton = driver.findElement(By.xpath("//button[@class ='Continue-Button Close-Cart']"));
        wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
        continueShoppingButton.click();


        /*WebElement continueShoppingBox = driver.findElement(By.xpath("//button[@class ='Continue-Button Close-Cart']"));
        wait.until(ExpectedConditions.visibilityOf(continueShoppingBox));
        continueShoppingBox.click();*/


    }

}
