import Utility.ExcelUtility;
import ExcelComparison.SheetData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.io.File;


public class TestExcelUtility{

    static File resourceDir = new File("src/test/resource");
    static String filePath = resourceDir.getAbsolutePath() + "/TestExcelRead.xlsx";
    static List<SheetData> sheetDataList;

    @BeforeClass public static void SetUp() throws IOException{
        sheetDataList = ExcelUtility.readExcel2007(filePath);
    }

    @Test
    public void TestSheetAmount(){
        Assert.assertEquals(sheetDataList.size(),2);
    }

    @Test
    public void TestSheetName(){
        Assert.assertEquals(sheetDataList.get(0).getSheetName(), "Sheet 1");
    }

    @Test
    public void TestSheetColumnHeader(){
        Assert.assertEquals(sheetDataList.get(1).getColumnHeader().get("A"), "555");
        Assert.assertEquals(sheetDataList.get(1).getColumnHeader().size(), 1);
    }

    @Test
    public void TestSheetRowLength(){ Assert.assertEquals(sheetDataList.get(0).getSheetData().size(), 10);}

    @Test
    public void TestEmptyCell(){
        Assert.assertEquals(sheetDataList.get(0).getSheetData().get(9).get(0), "");
    }

}
