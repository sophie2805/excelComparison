package ExcelComparison;

import Utility.ExcelUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Sophie on 2019/1/25.
 */
public class WorkbookData {

    public List<SheetData> getSheetsData() {
        return sheetsData;
    }

    private List<SheetData> sheetsData = new ArrayList<SheetData>();

    private String filePath;

    public WorkbookData(String path) throws IOException {
        this.filePath = path;
        sheetsData = ExcelUtility.readExcel2007(filePath);
    }
}
