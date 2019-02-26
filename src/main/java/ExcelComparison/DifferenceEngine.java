package ExcelComparison;

import java.util.*;

/**
 * Created by Sophie on 2019/1/26.
 */
public class DifferenceEngine {
    public static List<String> Differ(SheetData source, SheetData target) {

        List<String> differenceByRow = new ArrayList<String>();
        differenceByRow.add("Sheet Name: [" + source.getSheetName() + "]");
        differenceByRow.add("Discrepancy summary:");

        Set<String> unmatchColumns = new TreeSet<String>();

        int rowNum = source.getSheetData().size() > target.getSheetData().size() ?
                source.getSheetData().size() : target.getSheetData().size();


        for (int row = 0; row < rowNum; row++) {

            // target excel has more rows
            if(source.getSheetData().size()-1 < row) {
                differenceByRow.add("Row " + (row + 1));
                differenceByRow.add("    Source row null...");
                continue;
            }

            // source excel has more rows
            if(target.getSheetData().size()-1 < row) {
                differenceByRow.add("Row " + (row + 1));
                differenceByRow.add("    Target row null...");
                continue;
            }

            int cellNum = source.getSheetData().get(row).size() > target.getSheetData().get(row).size() ?
                    source.getSheetData().get(row).size() : target.getSheetData().get(row).size();

            for (int cell = 0; cell < cellNum; cell++) {

                String sourceCell = source.getSheetData().get(row).size() - 1 >= cell ?
                        source.getSheetData().get(row).get(cell) : "";
                String targetCell = target.getSheetData().get(row).size() - 1 >= cell ?
                        target.getSheetData().get(row).get(cell) : "";

                if (!sourceCell.equals(targetCell)) {
                    if(!differenceByRow.contains("Row " + (row + 1)))
                        differenceByRow.add("Row " + (row + 1));
                    StringBuilder sb = new StringBuilder();
                    sb.append("    Cell ");
                    sb.append(source.getHeaderIndexSequence().size() > target.getHeaderIndexSequence().size() ?
                            source.getHeaderIndexSequence().get(cell) : target.getHeaderIndexSequence().get(cell) );
                    sb.append(row + 1);
                    sb.append(": source -- ");
                    sb.append(sourceCell);
                    sb.append(", target -- ");
                    sb.append(targetCell);
                    differenceByRow.add(sb.toString());
                    String columnIndex = source.getHeaderIndexSequence().size()-1 >= cell ?
                            source.getHeaderIndexSequence().get(cell) : target.getHeaderIndexSequence().get(cell);
                    unmatchColumns.add("Column " + columnIndex + "(" + source.getColumnHeader().get(columnIndex)+ ")");
                } else
                    continue;
            }
        }

        String discrepancySummary = "Discrepancy summary: " + String.join(", " , unmatchColumns);
        differenceByRow.set(1, discrepancySummary);
        return differenceByRow;
    }
}
