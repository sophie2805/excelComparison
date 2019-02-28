package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.InputStream;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import ExcelComparison.*;

/**
 * Created by Sophie on 2019/1/25.
 */
public class ExcelUtility {

    public static List<SheetData> readExcel2007(String filePath) throws IOException{
        List<SheetData> rawData = new ArrayList<SheetData>();
        InputStream iS = new FileInputStream(filePath);

        try{
            XSSFWorkbook wb = new XSSFWorkbook(iS);
            int sheetAmount = wb.getNumberOfSheets();

            for(int i = 0; i < sheetAmount; i ++){
                List<List<String>> allData = new ArrayList<List<String>>();
                Map<String, String> columnHeader = new HashMap<String, String>();
                XSSFSheet sheet = wb.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                XSSFRow headerRow = sheet.getRow(0);
                if(headerRow != null){
                    for(int j = 0; j < headerRow.getLastCellNum(); j ++) {
                        DataFormatter formatter = new DataFormatter();
                        String h = formatter.formatCellValue(headerRow.getCell(j));
                        if (headerRow.getCell(j) != null && h.trim() != null && h.trim() != "")
                            columnHeader.put(headerRow.getCell(j).getAddress().toString().replaceAll("\\d+", ""), h);
                    }
                }
                int columnCount = columnHeader.size();
                List<String> dataInRow = null;
                for(int k = 0; k <= sheet.getLastRowNum(); k ++){
                    XSSFRow row = sheet.getRow(k);
                    dataInRow = new ArrayList<String>();
                    for(int j = 0; j < columnCount; j ++){
                        DataFormatter formatter = new DataFormatter();
                        dataInRow.add(formatter.formatCellValue(row.getCell(j)));
                    }
                    allData.add(dataInRow);
                }
                SheetData sd = new SheetData(sheetName, columnHeader, allData);
                rawData.add(sd);
            }
        }catch (IOException e){

        }
        finally {
            if(iS != null)
                iS.close();
        }
        return rawData;
    }
}
