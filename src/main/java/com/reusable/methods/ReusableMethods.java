package com.reusable.methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods  {
	
	
	public void elementclick(WebElement objtoclick, String webelementname) {
		try {
			objtoclick.click();
		}
		catch(Exception e){			
		}
		
	}

	
	
	
	public void elementselect(WebElement iselect, String selectvalue, String elementname) {
		
		
		try {
			
			Select select = new Select(iselect);
			select.selectByVisibleText(selectvalue);
		}
		catch(Exception e){			
		}
	}
}
