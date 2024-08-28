import Page_Object.DropdownList;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    private void setCookie (Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    ChromeOptions chromeOptions = new ChromeOptions().addArguments(
            "--no-sandbox", "--headless", "--disable-dev-shm-usage");

    FirefoxOptions firefoxOptions = new FirefoxOptions().addArguments(
            "--headless", "--disable-dev-shm-usage");

    private WebDriver getDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new IllegalArgumentException("Driver type is not supported");
        }
    }

    @Before
    public void start() {
        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);

        driver.get(DropdownList.URL);

        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));
        driver.navigate().refresh();
    }

    @After
    public void teardown(){
        driver.manage().deleteCookieNamed("Cartoshka");
        driver.quit();
    }
}

