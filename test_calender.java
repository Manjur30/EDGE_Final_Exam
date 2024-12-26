package Calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class test_calender {

    public static void main(String[] args) {
        // Setting up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win64\\chromedriver-win64\\//chromedriver.exe");

        // Add ChromeOptions to maximize the browser on startup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options); // Initialize WebDriver with options
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            // Navigate to Login Page
            driver.get("https://hachnat.stage-carelogix.de/sing-in");

            // Wait for Username, Password, and Login button to be visible and enter credentials
            WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("credential")));
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ant-btn")));

            username.sendKeys("Manjur");
            password.sendKeys("Carelogix24!!");
            loginButton.click();

            // Navigate to Calendar Page
            WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[2]/div/div/header/div/div[2]/nav/div[2]/div[2]/a")));
            targetElement.click();

            // Wait for the "Create New Calendar" button and click it
            WebElement createCalendarButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[2]/div/div/main/div/div/div[1]/div/div[1]/div/button/span[2]")));
            createCalendarButton.click();

            // Fill in the calendar name
            WebElement calendarNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='name']")));
            calendarNameField.sendKeys("New Calendar1");

            // Select "Public" from the dropdown
            WebElement calendarDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div/div/div/span[1]")));
            calendarDropdown.click();

            WebElement publicOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div/div[3]/div/div/span")));
            publicOption.click();

            // Click the Save button
            WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/form/div[2]/button/span")));
            buttonElement.click();

            // Click on the "Profile" button
            WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/header/div/div[3]/div[2]/a/div")));
            profileButton.click();

            // Logout
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/header/div/div[3]/div[2]/div/button")));
            logoutButton.click();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Test completed!");
            //driver.quit(); // Properly close the browser
        }
    }
}
