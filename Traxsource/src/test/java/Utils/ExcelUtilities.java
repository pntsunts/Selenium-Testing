package Utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtilities {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    public void setExcelFile(String excelFilePath,String sheetName) throws IOException, FileNotFoundException {

        File file =    new File(excelFilePath);


        FileInputStream inputStream = new FileInputStream(file);


        workbook=new XSSFWorkbook(inputStream);


        sheet=workbook.getSheet(sheetName);

    }

    public String getCellData(int rowNumber,int cellNumber){

        cell =sheet.getRow(rowNumber).getCell(cellNumber);

        //returning the cell value as string
        return cell.getStringCellValue();
    }

    public int getRowCountInSheet(){
        int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        return rowcount;
    }

    public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException {
        //creating a new cell in row and setting value to it
        sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
    }
}
