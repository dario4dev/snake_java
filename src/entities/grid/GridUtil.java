package entities.grid;

import Common.ScreenCoordinates;

public class GridUtil {
    public static int getLinearIndex(final int currentRow, final int currentColumn, final int gridRows, final int gridColumns) {
        return currentColumn + ((currentRow%gridRows) * gridColumns);
    }

    public static GridCoordinates getGridCoordinateFromScreenCoordinate(final ScreenCoordinates screenCoordinates, final GridInfo gridInfo) {
        final CellSize cellSize = new CellSize(gridInfo.getWidth()/gridInfo.getColumns(), gridInfo.getHeight()/gridInfo.getRows());
        final int cellX = screenCoordinates.getFirst() / cellSize.getFirst();
        final int cellY = screenCoordinates.getSecond() / cellSize.getSecond();
        return new GridCoordinates(cellX, cellY);
    }
}
