package org.step;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.LibGlobal;
import org.junit.Assert;
import org.locator.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef extends LibGlobal {
	LibGlobal global;

	@Given("user is on Google page")
	public void userIsOnGooglePage() {
		getDriver("chrome");
		launhUrl("https://www.google.com/");
	}

	@When("user enter text on search filed by given sheetname {string} and rownumber {int}")
	public void userEnterTextOnSearchFiledByGivenSheetnameAndRownumber(String string, Integer int1)
			throws IOException, InvalidFormatException {
	File file =new File("");
	FileInputStream fileInputStream =new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(fileInputStream);
	Sheet sheet = workbook.getSheet("sheetname");
	Row row = sheet.getRow(1);
	Cell cell = row.getCell(0);
	String s = cell.getStringCellValue();
	if (s.equals("java")) {
		cell.setCellValue("Selenium");
	}
	FileOutputStream stream = new FileOutputStream(file);
	workbook.write(stream);
	}

	@When("get the search count and add into excel")
	public void getTheSearchCountAndAddIntoExcel() {
		// WebElement getSearchText = driver.findElement(By.id("result-stats"));
		// String text = getSearchText.getText();
		// writeDateToExcel("C:\\\\Users\\\\vels\\\\Music\\\\CucumberPro\\\\TestFolder\\\\Book1.xlsx",
		// "Sheet1", 0, 1,
		// text);
	}
}
