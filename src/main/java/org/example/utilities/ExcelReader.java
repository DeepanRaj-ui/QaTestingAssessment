package org.example.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ExcelReader {
    static String filePath = "src/test/resources/testdata/LoginData.xlsx";

    public static List<String[]> readExcelData(String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        List<String[]> data = new ArrayList<>();

        DataFormatter dataFormatter = new DataFormatter();
        for (Row row : sheet) {
            int cellCount = row.getLastCellNum();
            String[] rowData = new String[cellCount];
            for (int i = 0; i < cellCount; i++) {
                rowData[i] = dataFormatter.formatCellValue(row.getCell(i));
            }
            data.add(rowData);
        }
        workbook.close();
        fileInputStream.close();
        return data;
    }
}
