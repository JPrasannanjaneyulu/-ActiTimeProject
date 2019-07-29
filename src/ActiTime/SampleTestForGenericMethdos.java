package ActiTime;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.org.apache.xpath.internal.operations.Bool;

import Utilities.WebGeneric;

public class SampleTestForGenericMethdos extends WebGeneric
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

String URL= "file:///C:/Users/janja/Desktop/ALL%20Web%20objects.html";
		
		System.setProperty("webdriver.chrome.driver", "D:\\batch229\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		Enter_Value_In_Textbox(".//*[@id='idfirst']", "Brahm");		
		Enter_Value_In_Textbox(".//*[@id='idlast']", "lastname");
		
		// -ve xpath
		Enter_Value_In_Textbox(".//*[@id='idlastNEW']", "lastname");
		
		String Firstname_Textbox_Val= Get_Vaue_From_Textbox(".//*[@id='idfirst']");
		System.out.println("Firstname_Textbox_Val=" +Firstname_Textbox_Val);
		

		String Lasttname_Textbox_Val= Get_Vaue_From_Textbox("//*[@id='idlast']");
		System.out.println("Lasttname_Textbox_Val=" +Lasttname_Textbox_Val);
		
		//-ve 
	 Firstname_Textbox_Val= Get_Vaue_From_Textbox(".//*[@id='idfirstg']");
		System.out.println("Firstname_Textbox_Val=" +Firstname_Textbox_Val);
		
		
		
		//  --------------------------------------------
		
		boolean Res= Verify_Given_Value_Is_Exist_In_Textbox("//*[@id='idlast']", Lasttname_Textbox_Val);
		System.out.println("Res="+Res);
		
		clear_value_from_Textbox("//*[@id='idlast']");
		
		Res= Verify_Given_Value_Is_Exist_In_Textbox("//*[@id='idlast']", Lasttname_Textbox_Val);
		System.out.println("Res="+Res);
		
		
	}

}
