package entities.grid;

public class CellScreenCoordinates {

    private int mScreenX;
    private int mScreenY;

    public CellScreenCoordinates(final int screenX, final int screenY) {
        mScreenX = screenX;
        mScreenY = screenY;
    }

    public CellScreenCoordinates() {
        this(0,0);
    }

    public int GetScreenX() {
        return mScreenX;
    }

    public int GetScreenY() {
        return mScreenY;
    }

    public void SetScreenX(final int value) {
        mScreenX = value;
    }

    public void SetScreenY(final int value) {
        mScreenY = value;
    }





}
