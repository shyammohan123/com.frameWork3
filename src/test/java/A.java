

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.swing.text.Element;import org.apache.poi.ss.format.CellNumberFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A {
	WebDriver driver;
	public void getdriver() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
	}
	public void driverGet(String url) {
		driver.get(url);
	}
	public void windowMaxima() {
driver.manage().window().maximize();
	}
		
	
	public String getTitel() {
String title = driver.getTitle();
return title;
	}
	
	public WebElement findElementByIdl( String attributevalue) {
WebElement findElement = driver.findElement(By.id(attributevalue));
return findElement;

}
	public WebElement findElementclass(String attributevalue) {
		WebElement element = driver.findElement(By.className("attribute value"));
		return element;
		
	}
	public WebElement findElementName(String attributevalue) {
		WebElement findElement = driver.findElement(By.name("attributevalue"));
		return findElement;
	}
	public WebElement findElementXpath(String attributevalue) {
		WebElement findElement = driver.findElement(By.name("attributevalue"));
		return findElement;
		
	}
public void elmentClick(WebElement element) {
	element.click();
	}
public String elementAttributeValue(WebElement element) {
	
		String attribute = element.getAttribute("value");
		return attribute;
		
	}
public void selectOptionByText(WebElement elemnent,String text) {
Select select=new Select(elemnent);
		select.selectByVisibleText(text);
	}
	
public void selectOptionByValue(WebElement elemnent,String value) {
Select select=new Select(elemnent);
	select.selectByValue(value);
}
public void alertaccept(WebElement element) {
   Alert a =driver.switchTo().alert();
    a.accept(); 
}
public void alertDissmis(WebElement element) {
		Alert b=driver.switchTo().alert();
				b.dismiss();
	}
public void driverQuit() {
		driver.quit();
	}
public void driverClose() {
		driver.close();
	}
public String driverGetUrl() {

		String url = driver.getCurrentUrl();
		System.out.println(url);
		return url;
	}
	
public void MoveToElementAction(WebElement element) {
Actions action =new Actions(driver);
	action.moveToElement(element).perform();	
	}
public void actionContextClick(WebElement element) {
		
		Actions action =new Actions(driver);
		action.contextClick(element).perform();
	}
public void DragandDropAction(WebElement target, WebElement source) {

		Actions action=new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
	
public void DoubleClick(WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
public void javaScriptExecutor(WebElement element) {
JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("argument[o].click[]",element);	
}	
public void javaexecutorScrollDown(WebElement scrollDowen) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("argument[0].scrollIintoView(true)",scrollDowen);
}	
	
public void javaexecutorScrollup(WebElement scrollUp) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("argument[0].scrollIintoView(true)",scrollUp);		
}	
public void frameString(String stringId) {
	driver.switchTo().frame(stringId);
}	
public void FrameIndex(String index) {
driver.switchTo().frame(index);
}	
public void frameName(String nameOrId) {
	driver.switchTo().frame(nameOrId);

}	
public WebElement getFirstSelectedOption(WebElement data) {
	Select se=new Select(data);
	WebElement option = se.getFirstSelectedOption();
	return option;	
}	

public    void getAllSelectedOpton(WebElement data) {
	Select se=new Select(data);
	List list = (List) se.getAllSelectedOptions();
	
}	
public void indexValue(WebElement element, int index) {
	Select se=new Select(element);
	se.selectByIndex(index);
}
public void disSelect(WebElement element) {
	Select se=new Select(element);
se.deselectAll();
}
	
public void disSelectByvisibleText(WebElement element,String text) {
	Select se=new Select(element);
	se.deselectByVisibleText(text);
	
}	
	
public void disSelectByvalue(WebElement element, String value) {
	Select se=new Select(element);
	se.deselectByValue(value);
}
public void disSelectByIndex(WebElement element,int index) {
	Select se=new Select(element);
	se.deselectByIndex(index);
}
public boolean isMultiple(WebElement element) {
	Select se=new Select(element);
	boolean multiple = se.isMultiple();
	return multiple;
}
public void windowStringId(String stringid) {
driver.switchTo().window(stringid);
}
public void WindowstringTitel(String titel) {
	driver.switchTo().window(getTitel());

}
public String WindowHandels() 
{
String windowHandle = driver.getWindowHandle();
return windowHandle;

}
public Set<String> windowhandels() {
	Set<String> handles = driver.getWindowHandles();
	return handles;
	
}

///////////////////////////////////////////////////////

	
					
					
			public String getDataFromExcel(String sheetName,int rowname,int CellNum  ) throws IOException {
				String data=null;
				File file=new File("C:\\Users\\user\\eclipse-workspace\\Employe\\excel\\Book1.xlsx");
				FileInputStream stream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(stream);
				Sheet sheet = workbook.getSheet(sheetName);
				Row row = sheet.getRow(rowname);
				Cell cell = row.getCell(CellNum);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					break;
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)){
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat reqFormat=new SimpleDateFormat("dd/MM/YYYY");
					String format = reqFormat.format(dateCellValue);
					
					data=format;
				}else {
							double numericCellValue = cell.getNumericCellValue();
							long round = Math.round(numericCellValue);
							if (round==numericCellValue) {
								String valueOf = String.valueOf(numericCellValue);
								data=valueOf;
								
							}
							
						

						
				}
				
					break;
				}

		return data;					
				
			
	
	
		
		
		








}}




