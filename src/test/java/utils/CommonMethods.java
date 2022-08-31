package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import steps.PageInitializer;

import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;
    public void openBrowserAndLaunchWebPage(){
        ConfigReader.readProperties(Constants.CONFIG_FILEPATH);

        switch(ConfigReader.getPropertyValue("browser").toLowerCase()){
            case("chrome"):
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case("safari"):
                WebDriverManager.safaridriver().setup();
                driver=new SafariDriver();
                break;
            case("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser provided");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

        //make sure to put method from Page initializer
        initializePageObjects();

    }

    public void closeBrowser(){
        driver.quit();
    }

    public void sendText(WebElement e,String text){
        e.clear();
        e.sendKeys(text);
    }

    public void click(WebElement e){
        e.click();
    }




}
