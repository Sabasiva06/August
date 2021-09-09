package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	public static WebDriver driver;

	public void getDriver(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"D:\\12.30PmFrameworkJuneBatch\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver", "D:\\12.30PmFrameworkJuneBatch\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("egde")) {
				System.setProperty("webdriver.edge.driver", "D:\\12.30PmFrameworkJuneBatch\\Driver\\geckodriver.exe");
				driver = new EdgeDriver();
			} else {
				System.out.println("Invalid browser");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void launhUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void typeText(WebElement element, String data) {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				element.sendKeys(data);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void btnClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public WebElement findById(String data, String id) {
		WebElement findElement = null;
		try {
			if (data.equalsIgnoreCase("Id")) {
				findElement = driver.findElement(By.id(id));
			} else if (data.equalsIgnoreCase("xpath")) {
				findElement = driver.findElement(By.xpath(id));
			} else if (data.equalsIgnoreCase("classname")) {
				findElement = driver.findElement(By.name(id));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return findElement;

	}

	public void moveToElement(WebElement target) {

		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(target).perform();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public String getValueByAttribute(WebElement element) {
		String attribute = null;
		try {
			attribute = element.getAttribute("value");
			System.out.println(attribute);
		} catch (Exception e) {
			System.out.println(e);
		}
		return attribute;

	}

	public void selectByDropDown(String name, WebElement element, String data) {

		try {
			Select select = new Select(element);
			if (name.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(data));
			} else if (name.equalsIgnoreCase("value")) {
				select.selectByValue(data);
			} else if (name.equalsIgnoreCase("visibleText")) {
				select.selectByVisibleText(data);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void enterTextByJs(String data, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void actionByMouse(WebElement element, String data) {
		try {

			Actions ac = new Actions(driver);
			ac.keyUp(element, Keys.SHIFT).sendKeys(data).keyDown(element, Keys.SHIFT).perform();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public String getDataFromExcel(String pathName, String sheetName, int rowNo, int cellNo) {
		String value = null;
		try {
			File file = new File(pathName);
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNo);
			Cell cell = row.getCell(cellNo);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();
			} else if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				value = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;

	}

	public void writeDateToExcel(String pathName, String sheetName, int rowNo, int CellNo, String value) {
		try {
			File file = new File(pathName);
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row createRow = sheet.getRow(rowNo);
			Cell createCell = createRow.createCell(CellNo);
			createCell.setCellValue(value);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			System.out.println("Donee!!!!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void screeanShot(String name) {
		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshotAs, new File(name + ".png"));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws IOException, InvalidFormatException {
		Sheet sheet = getSheetByName(excelFilePath, sheetName);
		return readSheet(sheet);
	}

	public Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
		Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
		return sheet;
	}

	public Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
		return WorkbookFactory.create(new FileInputStream(new File(excelFilePath)));

	}
	// public Sheet getSheetByName(String excelFilePath, String sheetName) throws
	// IOException {
	// FileInputStream fileInputStream = new FileInputStream(new
	// File(excelFilePath));
	// XSSFSheet sheet2 = new XSSFWorkbook(fileInputStream).getSheet(sheetName);
	//
	// return sheet2;
	// }

	public List<Map<String, String>> readSheet(Sheet sheet) {
		Row row;
		int totalRow = sheet.getPhysicalNumberOfRows();
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		int headerRowNumber = getHeaderRowNumber(sheet);
		if (headerRowNumber != -1) {
			int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
			int setCurrentRow = 1;
			for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
				row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
				}
				excelRows.add(columnMapdata);
			}
		}
		return excelRows;
	}

	public int getHeaderRowNumber(Sheet sheet) {
		Row row;
		int totalRow = sheet.getLastRowNum();
		for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
			row = getRow(sheet, currentRow);
			if (row != null) {
				int totalColumn = row.getLastCellNum();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					Cell cell;
					cell = row.getCell(currentColumn, Row.RETURN_BLANK_AS_NULL);
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						return row.getRowNum();

					} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						return row.getRowNum();

					} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
						return row.getRowNum();
					} else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
						return row.getRowNum();
					}
				}
			}
		}
		return (-1);
	}

	public Row getRow(Sheet sheet, int rowNumber) {
		return sheet.getRow(rowNumber);
	}

	public LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
		LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
		Cell cell;
		if (row == null) {
			if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.RETURN_BLANK_AS_NULL)
					.getCellType() != Cell.CELL_TYPE_BLANK) {
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, "");
			}
		} else {
			cell = row.getCell(currentColumn, Row.RETURN_BLANK_AS_NULL);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.RETURN_BLANK_AS_NULL)
						.getCellType() != Cell.CELL_TYPE_BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				}
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.RETURN_BLANK_AS_NULL)
						.getCellType() != Cell.CELL_TYPE_BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
				}
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.RETURN_BLANK_AS_NULL)
						.getCellType() != Cell.CELL_TYPE_BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, "");
				}
			} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.RETURN_BLANK_AS_NULL)
						.getCellType() != Cell.CELL_TYPE_BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
				}
			} else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.RETURN_BLANK_AS_NULL)
						.getCellType() != Cell.CELL_TYPE_BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
				}
			}
		}
		return columnMapdata;
	}

}
