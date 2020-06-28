package entities.grid;

import Common.ScreenCoordinates;
import engine.GameObject;

public abstract class CellContent extends GameObject {

    final CellContentType cellContentType;
    protected Grid grid = null;

    public CellContent(final CellContentType cellContentType) {
        this.cellContentType = cellContentType;
        grid = (Grid) GameObject.find(Grid.getGameObjectName());
    }

    public void setPositionGridCoordinates(final GridCoordinates gridCoordinates) {
        final ScreenCoordinates screenCoordinates = new ScreenCoordinates(gridCoordinates.getSecond() * grid.getCellSize().getFirst(),gridCoordinates.getFirst() * grid.getCellSize().getSecond());
        updatePosition(gridCoordinates, screenCoordinates);
    }

    public void setPositionScreenCoordinates(final ScreenCoordinates screenCoordinates) {
        final GridCoordinates gridCoordinates = GridUtil.getGridCoordinateFromScreenCoordinate(screenCoordinates, grid.getGridInfo());
        updatePosition(gridCoordinates, screenCoordinates);
    }

    private void updatePosition(final GridCoordinates gridCoordinates,final ScreenCoordinates screenCoordinates ) {
        grid.updateCellContent(cellContentType, gridCoordinates);
        getTransform().setPosition(screenCoordinates.getFirst(), screenCoordinates.getSecond());
    }

    public GridCoordinates getPositionGridCoordinates() {
        final GridCoordinates gridCoordinates = GridUtil.getGridCoordinateFromScreenCoordinate(new ScreenCoordinates(getTransform().getPositionX().intValue(), getTransform().getPositionY().intValue()), grid.getGridInfo());
        return gridCoordinates;
    }
}
