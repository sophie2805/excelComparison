package ExcelComparison;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by Sophie on 2019/1/26.
 */
public class CellDifference {

    private String source;
    private String target;
    private String cellAddress;

    public CellDifference(String source, String target, String cellAddress){
        this.source = source;
        this.target = target;
        this.cellAddress = cellAddress;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Cell ");
        sb.append(cellAddress);
        sb.append(": ");
        sb.append(" source -- ");
        sb.append(source);
        sb.append(", target -- ");
        sb.append(target);
        return sb.toString();
    }
}
