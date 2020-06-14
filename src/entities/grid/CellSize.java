package entities.grid;

public class CellSize {

    private int mWidth;
    private int mHeight;

    public CellSize() {
        this(0,0);
    }

    public CellSize(final int width, final int height) {
        mWidth = width;
        mHeight = height;
    }

    public int GetWidth() {
        return mWidth;
    }

    public int GetHeight() {
        return mHeight;
    }

    public void SetWidth(final int value) {
        mWidth = value;
    }

    public void SetHeight(final int value) {
        mHeight = value;
    }
}
