package entities.grid;
import Common.ScreenCoordinates;
import engine.GameObject;

import java.awt.*;
import java.util.Objects;

public class Cell extends GameObject {

    private CellContentType contentType;
    private final ScreenCoordinates screenCoordinates;
    private final GridCoordinates gridCoordinates;

    public Cell() {
        this(new GridCoordinates(0,0), new ScreenCoordinates(), new CellSize(100, 100));
    }

    public Cell(final GridCoordinates gridCoordinates, final ScreenCoordinates screenCoordinates, final CellSize size) {
        this.screenCoordinates = screenCoordinates;
        this.gridCoordinates = gridCoordinates;
        getTransform().setPosition(screenCoordinates.getFirst(), screenCoordinates.getSecond());
        getTransform().setScale((double)size.getFirst(), (double)size.getSecond());
        setContentType(CellContentType.EMPTY);
    }

    public CellContentType getContentType() {
        return contentType;
    }

    public void setContentType(CellContentType contentType) {
        this.contentType = contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cell cell = (Cell) o;
        return contentType == cell.contentType &&
                screenCoordinates.equals(cell.screenCoordinates) &&
                gridCoordinates.equals(cell.gridCoordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contentType, screenCoordinates, gridCoordinates);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "contentType=" + contentType +
                ", screenCoordinates=" + screenCoordinates +
                ", gridCoordinates=" + gridCoordinates +
                '}';
    }

    @Override
    protected void update(double v) {

    }

    @Override
    protected void render(Graphics graphics) {
        graphics.drawRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), getTransform().getScaleX().intValue(), getTransform().getScaleY().intValue());
    }
}
