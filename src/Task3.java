import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task3 {

    public static void main(String[] args) throws InterruptedException {
        //DID NOT FINISH YET
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

        WebElement payDebitCard = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        payDebitCard.click();

        WebElement payButton = driver.findElement(By.xpath("//button[normalize-space()='Pay 0.50 USD']"));
        payButton.click();

        //Thread.sleep(1500);

        WebElement invalidText = driver.findElement(By.xpath("//span[normalize-space()='Invalid EmailInvalid EmailInvalid Billing Name']"));
        wait.until(ExpectedConditions.elementToBeClickable(invalidText));
        String it = invalidText.getText();
        System.out.println(it);


    }

}
