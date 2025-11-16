package com.jala.qa.ParentLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesBase {
	public static Properties prop;
	 public static WebDriver driver;
	
	 public TesBase() throws IOException{
		 prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sai\\OneDrive\\Desktop\\project\\Selenium_Java_Project_Batch_Nov2025_9PM\\src\\main\\java\\com\\jala\\qa\\EnviromentalLayer\\config.properties");
	    prop.load(file);
	
	}
	
	
	public static void Intilization() {
		String browsername = prop.getProperty("Browser");
		
		switch(browsername) {
		case "chrome":  driver = new ChromeDriver();
		break;
		case "edge" : driver = new EdgeDriver();
		break;
		case "firefox": driver =  new FirefoxDriver();
		break;
		default:
			System.out.println("please check your browser name ...!");
			break;
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
				
	}
	
	public static void Hold() throws InterruptedException {
		Thread.sleep(3000);
	}
	
}
