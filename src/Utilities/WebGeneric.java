package Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebGeneric 
{
	public static WebDriver driver;
	
	

	//******************************************************************
	//----------------------->> Textbox  <<----------------------------
	//******************************************************************
	// username
	//  Enter_Value_In_Textbox("//input[@id='id101']", "admin")
	//  '?????????
	public static void Enter_Value_In_Textbox(String xpath, String ValueToBeEntered)
	{
		try
		{
			driver.findElement(By.xpath(xpath)).sendKeys(ValueToBeEntered);
		}
		
		catch(Exception e)
		{
			System.out.println("Textbox with given xpath='" +xpath  + "' is not found in page .Plz check xpath properly");
		}

	}
	
/*	String Firstname_Textbox_Val= Get_Vaue_From_Textbox(".//*[@id='idfirst']");
	System.out.println("Firstname_Textbox_Val=" +Firstname_Textbox_Val);
	
	String Lasttname_Textbox_Val= Get_Vaue_From_Textbox(".//*[@id='idlast']");
	System.out.println("Lasttname_Textbox_Val=" +Lasttname_Textbox_Val);
	
	//-ve 
 Firstname_Textbox_Val= Get_Vaue_From_Textbox(".//*[@id='idfirstg']");
	System.out.println("Firstname_Textbox_Val=" +Firstname_Textbox_Val);
	
*/
	public static String Get_Vaue_From_Textbox(String xpath)
	{
		String ActulaValFromTextbox = null ;
		try
		{
		 ActulaValFromTextbox = driver.findElement(By.xpath(xpath)).getAttribute("value");
		return ActulaValFromTextbox;
		}
		catch(Exception e)
		{
			System.out.println("Text box with given xapth = "+xpath +"is not found");
			return ActulaValFromTextbox;
		}
		//System.out.println("ActulaValFromTextbox= "+ActulaValFromTextbox);
	}

	//****************************************************************************************************
	
	/*boolean Res= Verify_Given_Value_Is_Exist_In_Textbox("//*[@id='idlast']", "Ramu");
	System.out.println("Res="+Res);
	*/
	public static boolean  Verify_Given_Value_Is_Exist_In_Textbox(String My_Xpath, String ExpectedValue)
	{
		String Actual_Val_From_Textbox;
		
		Actual_Val_From_Textbox =Get_Vaue_From_Textbox(My_Xpath);
		
		if (ExpectedValue.equals(Actual_Val_From_Textbox))
		{
			System.out.println("Passed. Texbox with given xpath='" +My_Xpath+ "' has E.V='" + ExpectedValue+ "' ,A.V="+ Actual_Val_From_Textbox  );
			return true;
			
		}
		else
		{
			System.out.println("Failed. Texbox with given xpath='" +My_Xpath+ "' has E.V='" + ExpectedValue+ "' ,A.V="+ Actual_Val_From_Textbox  );
			return false;
		}
				
	}
	//****************************************************************************************************
	
	public static void clear_value_from_Textbox(String My_Xpath)
	{
		driver.findElement(By.xpath(My_Xpath)).clear();
	}

	
	

//******************************************************************
//----------------------->> Dropdown  <<----------------------------
//******************************************************************
	//  Select_Given_Value_In_Dropdown("//select[@name='customerProject.shownCustomer']", "Customer1");
	public static void Select_Given_Value_In_Dropdown(String xpath, String ValueToBeSelected) throws InterruptedException
	{
		WebElement ele= driver.findElement(By.xpath(xpath));

		Select sel =new Select(ele);

		sel.selectByVisibleText(ValueToBeSelected);
		//Thread.sleep(9000);
		////sel.selectByIndex(3);

	}

	//?????????????????????????
	//Get_Selected_Value_From_Dropdown(xpath)

	
	//Verify_Given_Value_Is_Selected_In_Dropdown()
	
		

	// Verify_Given_Value_Is_Exist_In_Dropdown("//select[@name='customerProject.shownCustomer']",  "Customer1")
	public static boolean Verify_Given_Value_Is_Exist_In_Dropdown(String Xpath, String Expected_DropDown_Value)	
	{
		boolean valFound=false;		
		String Actual_OptionTagVal;
		// //select[@name='customerProject.shownCustomer']  /option
		Xpath= Xpath + "/option";
		List<WebElement> allOptionTags= driver.findElements(By.xpath(Xpath));

		for(WebElement Eachoption: allOptionTags)				
		{
			Actual_OptionTagVal = Eachoption.getText().trim();
			//System.out.println("Actual_OptionTagVal="+Actual_OptionTagVal);				
			if(Actual_OptionTagVal.trim().equals(Expected_DropDown_Value.trim()))
			{			
				System.out.println("Actual_OptionTagVal='" +Actual_OptionTagVal + "', Expected='"+Expected_DropDown_Value+"'");
				valFound = true;
				break;
			}	

		} // for loop

		if(valFound == true)
		{
			System.out.println("Given Dropdown Value='"+ Expected_DropDown_Value+ "' is found");
			return valFound;
		}
		else
		{
			System.out.println("Given Dropdown Value='"+Expected_DropDown_Value + "' is not found");
			return valFound;
		}
	}

	//

	// Verify_Dropdown_Contains_Given_Value("xpath", "Customer1;cutomer2")
	
	
	// Multi dropdown selection
	//Select_Multiple_Values_In_Dropdown()
	//Get_Selected_Values_Dropdown()
	
	// Is_Dropdown_MultiSelection()
	
	//Verify_Dropdown_Is_Multiple_Selected
	

	//******************************************************************


	//******************************************************************
	//----------------------->>   <<----------------------------
	//******************************************************************
	//  Click_Any_Webelement("");
	public static void Click_Any_Webelement(String xpath)
	{
		WebElement Ele= driver.findElement(By.xpath(xpath));
		Ele.click();

	}




	public static void wait_Browser(long wait) throws InterruptedException
	{
		Thread.sleep(wait);
	}

	public static void tearDown()
	{
		driver.quit();
	}

	



	//Verify_Button_With_Given_Text_Is_Exist_On_Page()
	public static boolean verify_Button_With_Given_Text_Is_Existed_On_Page(String Button_Name)
	{
		boolean flag=driver.findElement(By.xpath("//input[contains(@value,'"+Button_Name+"')]")).isDisplayed();
		return flag;
	}

	//Click_button_BAsedOn_Text_NAme()
	public static void click_Button_Based_On_Text_Name(String button_Name)
	{
		try
		{
			driver.findElement(By.xpath("//input[contains(@value,'"+button_Name+"')]")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//Click_button_BAsedOn_Text_NAme("Cancel")
	public static void click_Button_Based_On_Text_Name1(String Expected_Button_Text)
	{
		Boolean Buttonfound= false;
		List<WebElement>  AllButtonEles= driver.findElements(By.xpath("//input[@type='button']"));

		int AllButtonsCnt= AllButtonEles.size();
		System.out.println("AllButtonsCnt="+AllButtonsCnt);
		String Actual_Buttontext = null;
		for(int i=0; i<AllButtonsCnt; i++)// 4
		{
			Actual_Buttontext= AllButtonEles.get(i).getAttribute("value");			
			if(Actual_Buttontext.equals(Expected_Button_Text))
			{
				Buttonfound=true;
				AllButtonEles.get(i).click();
				break;
			}

		}// for loop

		// if no button found 
		if (Buttonfound==true)			
		{
			System.out.println("Expected_Button_Text='"+Expected_Button_Text + "' is found and clicked");
		}
		else
		{
			System.out.println("Expected_Button_Text='"+Expected_Button_Text + "' is not  found and not clicked");
		}


	}



	//	Checkbox:
	//	  click
	//	  get_Checkbox_Selected()

	public static void checkbox_For_All_Elements(String checkbox_Button_Name)
	{
		driver.findElement(By.xpath("//input[@name='"+checkbox_Button_Name+"' and @type='checkbox']")).click();
	}

	public static void verify_Checkbox_Button_With_Given_Text_Is_Existed_On_Page(String checkbox_Button_Name)
	{
		driver.findElement(By.xpath("//input[@name='"+checkbox_Button_Name+"' and @type='checkbox']")).isSelected();
	}


	//	Radio button:
	//	  click
	//	  Get_Raido_button_Selected
	//	

	public static void radio_Button_For_All_Elements(String radio_Button_Name)
	{
		driver.findElement(By.xpath("//input[@name='"+radio_Button_Name+"' and @type='radio']")).click();
	}

	public static void verify_Radio_Button_With_Given_Text_Is_Existed_On_Page(String radio_Button_Name)
	{
		driver.findElement(By.xpath("//input[@name='"+radio_Button_Name+"' and @type='checkbox']")).isSelected();
	}






}
