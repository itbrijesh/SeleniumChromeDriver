package com.project;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeConfiguration {
	
	private static Map<String,String> getData()
	{
		Map<String, String> map = new HashMap();
		
		map.put("it.brijesh@gmail.com", "it.brijesh1");
		
		return map;
	}
	
	public static void main(String [] args) throws InterruptedException, Exception
	{
		
		ExcelConfiguration excel = new ExcelConfiguration("C://Temp//Testdata.xlsx");
		
		String exePath = "C:\\Temp\\chrome-driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		final WebDriver driver = new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES); 
		driver.get("https://www.facebook.com/");
	
		
			/*List<List<String>> data1 = excel.getList();
			for (List<String> credentials : data1) {
			WebElement hello = driver.findElement(By.id("email"));
			hello.sendKeys(credentials.get(0));
			
			
			WebElement hello1 = driver.findElement(By.id("pass"));
		    hello1.sendKeys(credentials.get(1));
		   	
		
			driver.findElement(By.xpath("//*[@id='loginbutton']")).click();
			
			Thread.sleep(5000);
			
			driver.findElement(By.id("userNavigationLabel")).click();	 
			driver.findElement(By.xpath("//li[12]/a/span/span")).click();  
			
			Thread.sleep(5000);
			
			}*/
			
			final Map<String, String> data = getData();
			
			data.forEach( (username, password) -> {
				
				WebElement uid = driver.findElement(By.id("email"));
				uid.sendKeys( username );
				
				
				WebElement pwd = driver.findElement(By.id("pass"));
			    pwd.sendKeys( password );
			   	
			
				driver.findElement(By.xpath("//*[@id='loginbutton']")).click();
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//driver.findElement(By.id("userNavigationLabel")).click();	 
				//driver.findElement(By.xpath("//li[12]/a/span/span")).click();  
				
				System.out.println(">>>Loading Photos !!!!");
				driver.findElement(By.linkText("Photos") ).click();
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	}
}


 