package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<Object[]> readlogindata(String filePath, String sheetName) {
        List<Object[]> testData = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.err.println("Sheet not found: " + sheetName + " in file: " + filePath);
                return testData; // Return empty list if sheet is not found
            }
            int rowCount = sheet.getLastRowNum(); // Get index of last row
            int firstRowNum = sheet.getFirstRowNum();

            for (int i = firstRowNum + 1; i <= rowCount; i++) { // Start from the second row (index 1) to skip header
                Row row = sheet.getRow(i);
                if (row != null) {
                    int cellCount = row.getLastCellNum();
                    Object[] rowData = new Object[cellCount];
                    for (int j = 0; j < cellCount; j++) {
                        Cell cell = row.getCell(j);
                        rowData[j] = getCellValueAsString(cell);
                    }
                    testData.add(rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((long) cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
                return "";
            case FORMULA:
                try {
                    return cell.getStringCellValue();
                } catch (IllegalStateException e) {
                    return String.valueOf((long) cell.getNumericCellValue());
                }
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/resources/logindata.xlsx";
        String sheetName = "Sheet0";
        List<Object[]> data = ExcelReader.readlogindata(filePath, sheetName);

        for (Object[] row : data) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }

    public static Object[][] getlogindata(String sheetName) {
        String filePath = "src/main/resources/logindata.xlsx";
        List<Object[]> dataList = readlogindata(filePath, sheetName);
        Object[][] logindata = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            logindata[i] = dataList.get(i);
        }
        return logindata;
    }


}