import jdk.nashorn.internal.ir.IfNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task2 {

    public static void main(String[] args) throws InterruptedException {
        //PROMO CODE CHECKER
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Can\\Documents\\Selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebookAdd = driver.findElement(By.xpath("//div[2]//a[1]//div[1]//div[2]//button[1]"));
        ebookAdd.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(iFrame1));
        driver.switchTo().frame(iFrame1);

        WebElement addPromoCode = driver.findElement(By.xpath("//button[normalize-space()='Add Promo Code']"));
        addPromoCode.click();


        WebElement promoCodeBox = driver.findElement(By.className("Promo-Code-Value"));
        promoCodeBox.sendKeys("123456789");

        WebElement apply = driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
        apply.click();

        Thread.sleep(1500);

        WebElement promoCodeText = driver.findElement(By.xpath("//*[@id='SnackBar']/span"));
        wait.until(ExpectedConditions.elementToBeClickable(promoCodeText));
        String xx = promoCodeText.getText();
        String ipc = "Invalid promo code";
        if (xx.equals(ipc)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }


    }

}
