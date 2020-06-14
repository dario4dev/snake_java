package entities.grid;
import Common.ScreenCoordinates;
import engine.GameObject;

import java.awt.*;

public class Cell extends GameObject {

    CellContentType mContentType;

    public Cell() {
        this(new ScreenCoordinates(), new CellSize(100, 100));
    }

    public Cell(final ScreenCoordinates coordinates, final CellSize size) {
        GetTransform().setPosition(coordinates.GetScreenX(), coordinates.GetScreenY());
        GetTransform().setScale((double)size.GetWidth(), (double)size.GetHeight());

        mContentType = CellContentType.EMPTY;
    }

    @Override
    protected void update(double v) {

    }

    @Override
    protected void render(Graphics graphics) {
       // graphics.fillRect(mCoordinates.GetScreenX(),mCoordinates.GetScreenY(),mSize.GetWidth(),mSize.GetHeight());
        graphics.drawRect(GetTransform().getPositionX().intValue(),GetTransform().getPositionY().intValue(), GetTransform().getScaleX().intValue(), GetTransform().getScaleY().intValue());
    }
}
