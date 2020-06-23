package entities.grid;

public class CellSize {

    private int width;
    private int height;

    public CellSize() {
        this(0,0);
    }

    public CellSize(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(final int value) {
        width = value;
    }

    public void setHeight(final int value) {
        height = value;
    }
}
