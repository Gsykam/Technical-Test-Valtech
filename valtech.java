import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class valtech {

	private final static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

	public static void openBrowser() {

		System.out.println("Creating Chrome object");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\sudheerkumar.varala\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\sudheerkumar.varala\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driverThread.set(new FirefoxDriver());

	}

	public static WebDriver getDriver() {
		return driverThread.get();
	}

	public static void navigateToHomePage() {
		getDriver().navigate().to("www.valtech.com");

	}

	public static void navigateToMenu(String objectXpath) {
		getDriver().findElement(By.xpath(objectXpath)).click();

	}

	public static void main(String[] args) throws Exception {

		navigateToHomePage();
		if (getDriver().findElement(By.xpath("//text()[contains(.,'Latest news')]")).getText()
				.contains("Latest news")) {
			System.out.println("Latest News section is identified. Test case passed");

		} else {
			System.out.println("Test case failed, no latest nes is identified");

		}

		navigateToMenu("//a[@href='/about/']");
		Thread.sleep(3000);
		if (getDriver().findElement(By.xpath("//text()[contains(.,'About')]")).getAttribute("h1").equals("About")) {
			System.out.println("About section is identified. Test case passed");

		} else {
			System.out.println("Test case failed, no about section identified");

		}
	}

}
