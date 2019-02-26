package ExcelComparison;

import java.util.*;

/**
 * Created by Sophie on 2019/1/25.
 */
public class SheetData {

    private String sheetName;

    private Map<String, String> columnHeader;

    private List<String> headerIndexSequence;

    private List<List<String>> sheetData;

    public SheetData(String sheetName, Map<String, String> columnHeader, List<List<String>> sheetData){
        this.sheetName = sheetName;
        this.columnHeader = columnHeader;
        this.sheetData = sheetData;
        headerIndexSequence = new ArrayList<String>(columnHeader.keySet());
        Collections.sort(headerIndexSequence, String.CASE_INSENSITIVE_ORDER);
    }
    public Map<String, String> getColumnHeader() {
        return columnHeader;
    }

    public List<String> getHeaderIndexSequence() {
        return headerIndexSequence;
    }

    public List<List<String>> getSheetData() {
        return sheetData;
    }

    public String getSheetName() {
        return this.sheetName;
    }

}
