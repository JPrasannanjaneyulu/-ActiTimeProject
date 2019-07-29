package ActiTime;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import Utilities.WebGeneric;

public class ActiTest extends WebGeneric
{
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		Login();
		//Select_Value_From_Dropdown("//select[@name='customerProject.shownCustomer']", "Customer1");
		//Select_Value_From_Dropdown("//select[@name='customerProject.shownProject']","Project1");
		//click_Button_Based_On_Text_Name("Show Tasks");
		//click_Button_Based_On_Text_Name("Add New Tasks");
		//click_Button_Based_On_Text_Name("Add New TasksInavalid");
		/*Select_Value_From_Dropdown("//select[@name='customerId']", "Customer1");
		wait_Browser(3000);
		enter_Value_Into_Textbox("//input[@name='projectName']", "Project2");
		Select_Value_From_Dropdown("//select[@name='projectId']", "-- new project --");
		enter_Value_Into_Textbox("//input[@name='projectName']", "Project2");
		wait_Browser(3000);
		clear_value_from_Textbox("//input[@name='projectName']");
		wait_Browser(3000);
		enter_Value_Into_Textbox("//input[@name='task[0].name']", "This is prasanna");
		wait_Browser(3000);
		clear_value_from_Textbox("//input[@name='projectName']");
		wait_Browser(3000);
		tearDown();
		*/
			//create_Customer( "Test1109", "CusomterDescription",40,"Customer has been successfully registered.");
//			create_Customer( "Rajesh", "CusomterDescription",5,"Customer has been successfully registered.");
//			
//		validateCustomerInDropdown("Customer10");
//		validateCustomerInDropdown("Customer1");
//		validateCustomerInDropdown("Customer908");
			
		
		
		/*for(int i=0;i<5;i++)
		{
			String Buttontext= AllButtonEles.get(i).getAttribute("value");
			System.out.println("Buttontext="+Buttontext);
		}*/
			
			
//		
			
			
	}	// for loop
		
		
		
		
		
		//driver.close();



	public static void Login()
	{
		String URL= "http://desktop-5ji0naq/tasks/otasklist.do";
		
		System.setProperty("webdriver.chrome.driver", "D:\\batch229\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElement(By.name("username")).sendKeys("admin");
		//WebGeneric wg= new WebGeneric();
		
		//wg.Enter_Value_In_Textbox("username", "admin");
		Enter_Value_In_Textbox("username", "admin");
		
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
	}
	
	// create_Customer( "Ramu", "CusomterDescription",5,"Customer has been successfully registered.")
	public static void create_Customer(String CustomerName,String CusomterDescription,int n,String ExpectedMsg) throws InterruptedException
	{
		String xpathCust;
		driver.findElement(By.linkText("Projects & Customers")).click();
		
		
		//String ExpectedMsg= "Customer has been successfully registered.";
		
		for(int i=1;i<=n;i++)
		{
			driver.findElement(By.xpath("//input[@value='Add New Customer']")).click();
			WebElement custTable;
			
			CustomerName=CustomerName +i;
			driver.findElement(By.name("name")).sendKeys(CustomerName);
			driver.findElement(By.name("createCustomerSubmit")).click();
			String msg=driver.findElement(By.xpath("//span[@class='successmsg']")).getText();
			System.out.println(msg);
			
			if(msg.equals(ExpectedMsg))
			{
				System.out.println("Customer='" +CustomerName + "' created");
			}
			else
			{
			
				System.out.println("Customer='" +CustomerName + "' is not  created");
			}
			
			
			
			// sleect dropdwon val 

			
			Thread.sleep(4000);
			//Clk show 
			Click_Any_Webelement("//input[@type='button'] [contains(@value,'Show')]");
			//driver.findElement(By.xpath("//input[@type='button'] [contains(@value,'Show')]")).click();
			
			//Verify customer name is exist in table				
			xpathCust= "//*[@id='customersProjectsForm']/table/tbody/tr[5]/td/table//tr//td[1]//a[2][text()='" + CustomerName +"']";
			
			custTable = driver.findElement(By.xpath(xpathCust));
			if(custTable.isDisplayed())
			{
				System.out.println("Customer='" +CustomerName + "' is exist in table");
			}
			else				
			{
				System.out.println("Customer='" +CustomerName + "' is not exist in table");
			}
			
			
		}
	}
	//Verify customer name is exist on customer drop down 
	// validateCustomerInDropdown( "cutomer10")
	public static void validateCustomerInDropdown(String CustomerName)
	{
		boolean valFound;

		valFound= Verify_Given_Value_Is_Exist_In_Dropdown("//select[@name='customerProject.shownCustomer']",  CustomerName);	

		if(valFound)
		{
			System.out.println("Customer='" +CustomerName + "' is exist in dropdown");
		}
		else				
		{
			System.out.println("Customer='" +CustomerName + "' is not exist in dropdown");
		}		
	}  // Method
	
	

	
	
	
	
	
	
	
} // class
