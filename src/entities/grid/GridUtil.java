package entities.grid;

public class GridUtil {
    public static int getLinearIndex(final int currentRow, final int currentColumn, final int gridRows, final int gridColumns) {
        return currentColumn + ((currentRow%gridRows) * gridColumns);
    }
}
