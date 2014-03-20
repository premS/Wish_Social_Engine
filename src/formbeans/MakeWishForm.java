//lily
package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class MakeWishForm extends FormBean {

	private String wishName;
	
	public String getWishName()  { return wishName; }
	
	public String getWishNameShort()  { 
		if (wishName.toLowerCase().contains("travel")) 
			wishName="travel";
		else if (wishName.toLowerCase().contains("boyfriend")|wishName.toLowerCase().contains("girlfriend")|wishName.toLowerCase().contains("bf")|wishName.toLowerCase().contains("gf")) 
			wishName="bfgf";
		else if (wishName.toLowerCase().contains("health")|wishName.toLowerCase().contains("fit")) 
			wishName="health";
		else if (wishName.toLowerCase().contains("family")) 
			wishName="family";
		else if (wishName.toLowerCase().contains("straight")) 
			wishName="a";
		return wishName; 
	}
	
	public void setWishName(String s) { wishName = trimAndConvert(s,"<>\"");  }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (wishName == null || wishName.length() == 0) {
			errors.add("Wish is required");
		}
		
		return errors;
	}
}
