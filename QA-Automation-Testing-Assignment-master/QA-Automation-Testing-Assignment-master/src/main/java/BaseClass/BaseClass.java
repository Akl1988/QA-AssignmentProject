package BaseClass;


import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Properties;

import java.util.concurrent.TimeUnit;


import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.PageLoadStrategy;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;


import com.qa.Utilities.Utilities;

import com.qa.Utilities.WebEventListener;


public class BaseClass {
	
	
public static WebDriver driver;
	
public static Properties prop;
	
public  static EventFiringWebDriver e_driver;
	
public static WebEventListener eventListener;

	
public BaseClass() {
		
try {
			
prop = new Properties
FileInputStream ip = new FileInputStream("C:/Users/DELL/Downloads/QA-Automation-Testing-Assignment-master/"
					
+ "QA-Automation-Testing-Assignment-master/src/main/java/com/qa"
					
+ "/Properties/AutomationPractice.properties");
			
prop.load(ip);
		
} catch (FileNotFoundException e) {
			
e.printStackTrace();
		
} catch (IOException e) {
			
e.printStackTrace();
		
}
	
}

	
public static void initialization(){
		
String browserName = prop.getProperty("browser");
		
		
if(browserName.equals("chrome")){
			
System.setProperty("webdriver.chrome.driver", "C:/Users/DELL/Downloads/QA-Automation-Testing-Assignment-master/"

					+ "QA-Automation-Testing-Assignment-master/Drivers/chromedriver.exe");	
			
driver = new ChromeDriver(); 
		
}
		
else if(browserName.equals("FF")){
			
System.setProperty("webdriver.gecko.driver", "C:/Users/DELL/Downloads/QA-Automation-Testing-Assignment-master/"
					
+ "QA-Automation-Testing-Assignment-master/Drivers/geckodriver.exe");	
driver = new FirefoxDriver(); 
		}
		
		
		
e_driver = new EventFiringWebDriver(driver);
		
eventListener = new WebEventListener();
		
e_driver.register(eventListener);
		
driver = e_driver;
		
		
driver.manage().window().maximize();
		
driver.manage().deleteAllCookies();
		
driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
driver.get(prop.getProperty("url"));
		}
	}