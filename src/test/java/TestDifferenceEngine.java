import ExcelComparison.DifferenceEngine;
import Utility.ExcelUtility;
import ExcelComparison.SheetData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.io.File;

public class TestDifferenceEngine {

    static File resourceDir = new File("src/test/resource");
    static String sourceFilePath = resourceDir.getAbsolutePath() + "/Source.xlsx";
    static String targetFilePath = resourceDir.getAbsolutePath() + "/Target.xlsx";
    static List<SheetData> source, target;
    static List<String> comparisonResultSheet1, comparisonResultSheet2;

    @BeforeClass
    public static void ReadExcel() throws IOException{
        source = ExcelUtility.readExcel2007(sourceFilePath);
        target = ExcelUtility.readExcel2007(targetFilePath);
        comparisonResultSheet1 = DifferenceEngine.Differ(source.get(0), target.get(0));
        comparisonResultSheet2 = DifferenceEngine.Differ(source.get(1), target.get(1));
        boolean a = comparisonResultSheet1.contains("Sheet 1");
        int aa = comparisonResultSheet1.indexOf("Sheet 1");
    }

    @Test
    public void TestComparisonResultSheetName(){
        Assert.assertTrue(comparisonResultSheet1.contains("Sheet Name: [Sheet 1]"));
    }

    @Test
    public void TestComparisonResultCellDifference(){
        Assert.assertTrue(comparisonResultSheet1.contains("Row 7"));
        Assert.assertTrue(comparisonResultSheet1.contains("    Cell A7: source -- , target -- Title that not in source"));
    }

    @Test
    public void TestComparisonResultSummary(){
        Assert.assertTrue(comparisonResultSheet1.contains("Discrepancy summary: Column A(title), Column C(album), Column D(isFound)"));
    }

    @Test
    public void TestComparisonResultEmptyRow(){
        Assert.assertTrue(comparisonResultSheet1.contains("Row 10"));
        Assert.assertTrue(comparisonResultSheet1.contains("    Target row null..."));
    }
}
