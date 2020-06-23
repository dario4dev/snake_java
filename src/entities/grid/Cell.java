package entities.grid;
import Common.ScreenCoordinates;
import engine.GameObject;

import java.awt.*;

public class Cell extends GameObject {

    private CellContentType contentType;

    public Cell() {
        this(new ScreenCoordinates(), new CellSize(100, 100));
    }

    public Cell(final ScreenCoordinates coordinates, final CellSize size) {
        getTransform().setPosition(coordinates.getScreenX(), coordinates.getScreenY());
        getTransform().setScale((double)size.getWidth(), (double)size.getHeight());

        contentType = CellContentType.EMPTY;
    }

    @Override
    protected void update(double v) {

    }

    @Override
    protected void render(Graphics graphics) {
        graphics.drawRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), getTransform().getScaleX().intValue(), getTransform().getScaleY().intValue());
    }
}
