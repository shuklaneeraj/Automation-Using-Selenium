package com.dxc.sale.test.framework.generic;

import org.openqa.selenium.By;

import com.dxc.sale.test.framework.db.ObjectRepo;

public class SeliniumUtil {
	
	public static By getElement(String name) {
		ObjectRepo repo = new ObjectRepo();
		String webElementName = repo.readProperty(name);
		String webElementType = repo.readPropLoc(name);
		By by = null;
		switch (webElementType) {
			case "NAME":
				by = By.name(webElementName);
				break;
			case "ID":
				by = By.id(webElementName);
				break;
			case "CLASSNAME":
				by = By.className(webElementName);
				break;
			case "XPATH":
				by = By.xpath(webElementName);
				break;
			case "LINKTEXT":
				by = By.linkText(webElementName);
				break;	
			case "TAGNAME":
				by = By.tagName(webElementName);
				break;					
			default:
				break;
		}
		return by;
	}
	

}

