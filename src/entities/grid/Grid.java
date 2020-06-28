package entities.grid;

import Common.ScreenCoordinates;
import engine.GameObject;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Grid extends GameObject {

    private Cell[] cells = null;
    private GridInfo gridInfo = null;
    private CellSize cellSize = null;
    private Map<CellContentType, Cell> cellContentTypeToCellMap;

    public Grid(final GridInfo gridInfo) {
        this.setName(Grid.getGameObjectName());
        this.gridInfo = gridInfo;
        cellContentTypeToCellMap = new HashMap<CellContentType, Cell>();

        cells = new Cell[this.gridInfo.getRows() * this.gridInfo.getColumns()];
        cellSize = new CellSize(this.gridInfo.getWidth()/this.gridInfo.getColumns(), this.gridInfo.getHeight()/this.gridInfo.getRows());
        for(int y = 0; y < this.gridInfo.getRows(); ++y) {
            for(int x = 0; x < this.gridInfo.getColumns(); ++x) {
                final int linearIndex = GridUtil.getLinearIndex(y,x,this.gridInfo.getRows(), this.gridInfo.getColumns());
                cells[linearIndex] = new Cell(new GridCoordinates(y,x), new ScreenCoordinates(x* cellSize.getFirst(), y* cellSize.getSecond()), cellSize);
            }
        }

        //Initialise snake position in the grid
        final int snakeCellRow = this.gridInfo.getRows()/2;
        final int snakeCellColumn = this.gridInfo.getColumns()/2;
        final int snakeCellIndex = GridUtil.getLinearIndex(snakeCellRow,snakeCellColumn,this.gridInfo.getRows(), this.gridInfo.getColumns());
        cellContentTypeToCellMap.put(CellContentType.SNAKE, cells[snakeCellIndex]);
        updateStatus(CellContentType.SNAKE, new GridCoordinates(snakeCellRow, snakeCellColumn));
    }

    public GridInfo getGridInfo() {
        return gridInfo;
    }

    public CellSize getCellSize(){
        return cellSize;
    }

    static public String getGameObjectName() {
        return "Grid";
    }

    public boolean isValidGridCoordinate(final GridCoordinates gridCoordinates) {
        return gridCoordinates.getFirst() >= 0 && gridCoordinates.getFirst() < gridInfo.getColumns()
                && gridCoordinates.getSecond() >= 0 && gridCoordinates.getSecond() < gridInfo.getRows();
    }

    public void updateStatus(final CellContentType cellContentType, final GridCoordinates gridCoordinates) {
        cellContentTypeToCellMap.computeIfPresent(cellContentType, (key, value) -> {
//            System.out.println("Start Updating content ");
//            System.out.println("Current content type " + cellContentType + " to cell " + value);
            value.setContentType(CellContentType.EMPTY);
            //System.out.println("New content type " + cellContentType + " to cell " + value);
            final int linearIndex = GridUtil.getLinearIndex(gridCoordinates.getFirst(),gridCoordinates.getSecond(),this.gridInfo.getRows(), this.gridInfo.getColumns());
            value = cells[linearIndex];
         //   System.out.println("Current content type " + cellContentType + " to cell " + value);
            value.setContentType(cellContentType);
          //  System.out.println("New content type " + cellContentType + " to cell " + value);
       //     System.out.println("End Updating content ");
            return value;
        });
    }

    public Cell getCellByContent(final CellContentType cellContentType) {
        return cellContentTypeToCellMap.get(cellContentType);
    }

    @Override
    protected void update(double v) {
    }

    @Override
    protected void render(Graphics graphics) {
    }
}
