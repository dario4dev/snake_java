package entities.grid;

import Common.ScreenCoordinates;

public class Grid {

    private Cell[] cells = null;
    private int rows;
    private int columns;
    private CellSize cellSize = null;

    public Grid(final int rows, final int columns, final int width, final int height) {
        this.rows = rows;
        this.columns = columns;
        cells = new Cell[rows * columns];
        cellSize = new CellSize(width/columns, height/rows);
        for(int y = 0; y < this.rows; ++y) {
            for(int x = 0; x < this.columns; ++x) {
                final int linearIndex = GridUtil.getLinearIndex(y,x,rows, columns);
                cells[linearIndex] = new Cell(new ScreenCoordinates(x* cellSize.getWidth(), y* cellSize.getHeight()), cellSize);
            }
        }
    }

    public CellSize getCellSize(){
        return cellSize;
    }
}
