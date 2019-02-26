package ExcelComparison;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SheetDifference {

    private Set unmatchColumns;
    private List<List<String>> differenceByRow;

    public SheetDifference(Set unmatchColumns, List<List<String>> differenceByRow){
        this.unmatchColumns = unmatchColumns;
        this.differenceByRow = differenceByRow;
    }

    public List<String> toStringList(){
        List<String> sheetDifference = new ArrayList<String>();
        //sheetDifference.add()
        return null;
    }

}
