package Ecommerce.mycs.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author Gurup
 */
public class ExcelUtility {

	public String getDataFromXlsxFile(String path, String sheet, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}

	public double getDataFromXlsxFileNumeric(String path, String sheet, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		double data = wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		wb.close();
		return data;
	}

	public String getDataFromXlsx(String sheet, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\eclipse\\Mycs\\src\\main\\resources\\entire.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}

	public double getDataFromXlsxNumberic(String sheet, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\eclipse\\Mycs\\src\\main\\resources\\entire.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		double data = wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		wb.close();
		return data;
	}

	public void getReadDataBackFromXlsxString(String sheet, int row, int cell, String newValue) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\eclipse\\entire\\src\\main\\resources\\entire.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Row data = wb.getSheet(sheet).getRow(row);
		Cell cll = data.getCell(cell);
		cll.setCellType(CellType.STRING);
		cll.setCellValue(newValue);

		FileOutputStream fos = new FileOutputStream("C:\\eclipse\\entire\\src\\main\\resources\\entire.xlsx");
		wb.write(fos);
		wb.close();

	}

	public void getReadDataBackFromXlsxNumeric(String sheet, int row, int cell, String newValue) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\eclipse\\entire\\src\\main\\resources\\entire.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Row data = wb.getSheet(sheet).getRow(row);
		Cell cll = data.getCell(cell);
		cll.setCellType(CellType.NUMERIC);
		cll.setCellValue(newValue);

		FileOutputStream fos = new FileOutputStream("C:\\eclipse\\entire\\src\\main\\resources\\entire.xlsx");
		wb.write(fos);
		wb.close();
	}

	public int getLastRownum(String sheet) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\eclipse\\entire\\src\\main\\resources\\entire.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int data = wb.getSheet(sheet).getLastRowNum();
		return data;
	}

	public void getMultipleCellData(String sheet, int column1, int column2) throws Exception {
		String data1 = null;
		String data2 = null;
		FileInputStream fis = new FileInputStream("C:\\eclipse\\entire\\src\\main\\resources\\entire.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int lr = sh.getLastRowNum();
		for (int i = 0; i <= lr; i++) {
			data1 = sh.getRow(i).getCell(column1).toString();
			data2 = sh.getRow(i).getCell(column2).toString();
		}
		System.out.println(data1);
		System.out.println(data2);
	}
	public CharSequence getDataFromXlsc(String sheet, int row, int cell) throws Exception {
	    FileInputStream fis = new FileInputStream("C:\\eclipse\\Mycs\\src\\main\\resources\\entire.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    CharSequence data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	    wb.close();
	    return data;

}
}