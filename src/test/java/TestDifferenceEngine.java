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
    static List<String> comparisonResultSheet;

    @BeforeClass
    public static void ReadExcel() throws IOException{
        source = ExcelUtility.readExcel2007(sourceFilePath);
        target = ExcelUtility.readExcel2007(targetFilePath);
        comparisonResultSheet = DifferenceEngine.Differ(source.get(0), target.get(0));
    }

    @Test
    public void TestComparisonResultSheetName(){
        Assert.assertTrue(comparisonResultSheet.contains("Sheet Name: [Sheet 1]"));
    }

    @Test
    public void TestComparisonResultCellDifference(){
        Assert.assertTrue(comparisonResultSheet.contains("Row 7"));
        Assert.assertTrue(comparisonResultSheet.contains("    Cell A7: source -- , target -- Title that not in source"));
    }

    @Test
    public void TestComparisonResultSummary(){
        Assert.assertTrue(comparisonResultSheet.contains("Discrepancy summary: Column A(title), Column C(album), Column D(isFound)"));
    }

    @Test
    public void TestComparisonResultEmptyRow(){
        Assert.assertTrue(comparisonResultSheet.contains("Row 10"));
        Assert.assertTrue(comparisonResultSheet.contains("    Target row null..."));
    }
}
