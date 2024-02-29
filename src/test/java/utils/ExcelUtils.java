package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static void excel(String usermail, String username,String language, List<String> countries, List<List<String>> queries) throws IOException {
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\excelsheet\\output.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//Storing Employee Name and ID
		XSSFSheet sheet1=workbook.createSheet("UserInfo");
		XSSFRow row=sheet1.createRow(0);
		row.createCell(0).setCellValue("Employee Mail");
		row.createCell(1).setCellValue(usermail);
		XSSFRow row1=sheet1.createRow(1);
		row1.createCell(0).setCellValue("Employee Name");
		row1.createCell(1).setCellValue(username);
		
		
		//Storing language Selected
		XSSFSheet sheet2=workbook.createSheet("Country1");
		XSSFRow row2=sheet2.createRow(0);
		row2.createCell(0).setCellValue("Language Selected");
		row2.createCell(1).setCellValue(language);
		
		//Storing country1 and queries
		XSSFRow row3=sheet2.createRow(2);
		row3.createCell(0).setCellValue("Country Selected");
		row3.createCell(1).setCellValue(countries.get(0));
		
		XSSFRow row4=sheet2.createRow(4);
		for(int i=0;i<queries.get(0).size();i++) {
			row4.createCell(i).setCellValue(queries.get(0).get(i));
		}
		
		//Storing language Selected
		XSSFSheet sheet3=workbook.createSheet("Country2");
		XSSFRow row5=sheet3.createRow(0);
		row5.createCell(0).setCellValue("Language Selected");
		row5.createCell(1).setCellValue(language);
		
		//Storing country1 and queries
		XSSFRow row6=sheet3.createRow(2);
		row6.createCell(0).setCellValue("Country Selected");
		row6.createCell(1).setCellValue(countries.get(1));
		
		XSSFRow row7=sheet3.createRow(4);
		for(int i=0;i<queries.get(1).size();i++) {
			row7.createCell(i).setCellValue(queries.get(1).get(i));
		}
		
		
		workbook.write(file);
		workbook.close();
		file.close();
	}
}
