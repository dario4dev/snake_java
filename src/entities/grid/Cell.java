package entities.grid;
import engine.GameObject;

import java.awt.*;

public class Cell extends GameObject {

    CellScreenCoordinates mCoordinates;
    CellSize mSize;
    CellContentType mContentType;

    public Cell() {
        this(new CellScreenCoordinates(), new CellSize(100, 100));
    }

    public Cell(final CellScreenCoordinates coordinates, final CellSize size) {
        mCoordinates = coordinates;
        mSize = size;
        mContentType = CellContentType.EMPTY;
    }
    public void SetCoordinates(final CellScreenCoordinates coordinates) {
        mCoordinates = coordinates;
    }
    @Override
    protected void update(double v) {

    }

    @Override
    protected void render(Graphics graphics) {
       // graphics.fillRect(mCoordinates.GetScreenX(),mCoordinates.GetScreenY(),mSize.GetWidth(),mSize.GetHeight());
        graphics.drawRect(mCoordinates.GetScreenX(),mCoordinates.GetScreenY(),mSize.GetWidth(),mSize.GetHeight());
    }
}
