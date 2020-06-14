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
        GetTransform().SetPosition(coordinates.GetScreenX(), coordinates.GetScreenY());
        GetTransform().SetScale((double)size.GetWidth(), (double)size.GetHeight());

        mContentType = CellContentType.EMPTY;
    }

    @Override
    protected void Update(double v) {

    }

    @Override
    protected void Render(Graphics graphics) {
        graphics.drawRect(GetTransform().GetPositionX().intValue(),GetTransform().GetPositionY().intValue(), GetTransform().GetScaleX().intValue(), GetTransform().GetScaleY().intValue());
    }
}
