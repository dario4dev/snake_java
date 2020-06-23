package Common;

public class ScreenCoordinates {

    private int screenX;
    private int screenY;

    public ScreenCoordinates(final int screenX, final int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
    }

    public ScreenCoordinates() {
        this(0,0);
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public void setScreenX(final int value) {
        screenX = value;
    }

    public void setScreenY(final int value) {
        screenY = value;
    }





}
