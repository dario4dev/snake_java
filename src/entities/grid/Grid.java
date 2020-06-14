package entities.grid;

import Common.ScreenCoordinates;

public class Grid {

    private Cell[] mCells = null;
    private int mRows;
    private int mColumns;
    private CellSize mCellSize = null;

    public Grid(final int rows, final int columns, final int width, final int height) {
        mRows = rows;
        mColumns = columns;
        mCells = new Cell[rows * columns];
        mCellSize = new CellSize(width/columns, height/rows);
        for(int y = 0; y < mRows; ++y) {
            for(int x = 0; x < mColumns; ++x) {
                final int linearIndex = GridUtil.GetLinearIndex(y,x,rows, columns);
                mCells[linearIndex] = new Cell(new ScreenCoordinates(x*mCellSize.GetWidth(), y*mCellSize.GetHeight()), mCellSize);
            }
        }
    }

    public CellSize GetCellSize(){
        return mCellSize;
    }
}
