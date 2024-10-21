package excelIntegration;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataFile {

	public static String[][] excelCode() throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./data/Salesforce.xlsx");

		// XSSFSheet sheet=wb.getSheet("Sheet1");
		XSSFSheet sheet = wb.getSheetAt(1);

		int rowCount = sheet.getLastRowNum();

		int cellCount = sheet.getRow(1).getLastCellNum();

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {

				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				// System.out.println(stringCellValue);

				data[i - 1][j] = stringCellValue;

			}
		}

		wb.close();
		return data;

	}

}
