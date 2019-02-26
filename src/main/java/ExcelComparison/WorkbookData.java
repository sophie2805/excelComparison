package ExcelComparison;

import Utility.ExcelUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Sophie on 2019/1/25.
 */
public class WorkbookData {

    public List<SheetData> getWorkbook() {
        return workbookData;
    }

    private List<SheetData> workbookData = new ArrayList<SheetData>();

    private String filePath;

    public WorkbookData(String path) throws IOException {
        this.filePath = path;
        workbookData = ExcelUtility.readExcel2007(filePath);
    }

    public static void main(String[] args) throws IOException {
        WorkbookData source = new WorkbookData("/Users/Sophie/Downloads/starred.xlsx");
        WorkbookData target = new WorkbookData("/Users/Sophie/Downloads/starred_target.xlsx");
        List<String> a = DifferenceEngine.Differ(source.getWorkbook().get(0), target.getWorkbook().get(0));
        for(String aa : a)
         System.out.println(aa);
    }
}
