package is.ru.arnlaugsson.chuck_joke;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;


public abstract class SeleniumTestWrapper {
    //static ChromeDriver driver;
    static PhantomJSDriver driver;
    static String baseUrl;
    static String port;

    @BeforeClass
    public static void openBrowser(){
        //driver = new ChromeDriver();
        driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        port = System.getenv("PORT");
        if (port == null) {
            port = "4567";
        }
        baseUrl = "http://localhost:" + port;
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
