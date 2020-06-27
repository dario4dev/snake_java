package entities.grid;

public class GridInfo {

    private final int rows;
    private final int columns;
    private final int width;
    private final int height;

    public GridInfo(final int rows, final int columns, final int width, final int height) {
        this.rows = rows;
        this.columns = columns;
        this.width = width;
        this.height = height;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
