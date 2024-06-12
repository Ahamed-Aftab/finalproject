package mavenpractice.Project_Final2024;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base 
{

	WebDriver driver;
	public WebDriver initializeDriver() throws IOException, InterruptedException
	{
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Project_Final2024\\src\\main\\java\\data.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		 if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\Softwares\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(option);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			//driver.manage().window().setSize(null);
		}
		// if()
		
		return driver;
		
	}
	public String getUrl() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Project_Final2024\\src\\main\\java\\data.properties");
		prop.load(fis);
		String url=prop.getProperty("url");
		return url;
		
	}
	public void takeScreenshot(WebDriver driver,String path)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try 
        {
        	String destinationFile = System.getProperty("user.dir")+"\\screenshots\\"+path+".png";
        	FileUtils.copyFile(scrFile,new File(destinationFile));
			//FileUtils.copyFile(scrFile, new File("./pageloadimage.png"));
		} catch (IOException e1) 
        {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			
		}
	}
}
