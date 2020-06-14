package Common;

public class ScreenCoordinates {

    private int mScreenX;
    private int mScreenY;

    public ScreenCoordinates(final int screenX, final int screenY) {
        mScreenX = screenX;
        mScreenY = screenY;
    }

    public ScreenCoordinates() {
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
