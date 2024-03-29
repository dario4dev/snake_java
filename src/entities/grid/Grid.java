package entities.grid;

import Common.ScreenCoordinates;
import engine.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Grid extends GameObject {

    private Cell[] cells = null;
    private GridInfo gridInfo = null;
    private CellSize cellSize = null;
    private BufferedImage gridBackground;

    public Grid(final GridInfo gridInfo) {
        this.setName(Grid.getGameObjectName());
        this.gridInfo = gridInfo;

        cells = new Cell[this.gridInfo.getRows() * this.gridInfo.getColumns()];
        cellSize = new CellSize(this.gridInfo.getWidth()/this.gridInfo.getColumns(), this.gridInfo.getHeight()/this.gridInfo.getRows());
        for(int y = 0; y < this.gridInfo.getRows(); ++y) {
            for(int x = 0; x < this.gridInfo.getColumns(); ++x) {
                final int linearIndex = GridUtil.getLinearIndex(y,x,this.gridInfo.getRows(), this.gridInfo.getColumns());
                cells[linearIndex] = new Cell(new GridCoordinates(y,x), new ScreenCoordinates(x* cellSize.getFirst(), y* cellSize.getSecond()), cellSize);
            }
        }
        loadResources();
    }

    public void init() {
        for(Cell cell : cells) {
            cell.setContentType(CellContentType.EMPTY);
        }
    }

    private void loadResources() {
        File path = new File("resources/textures");
        try {
            gridBackground = ImageIO.read(new File(path, "grid_background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public GridInfo getGridInfo() {
        return gridInfo;
    }

    public CellSize getCellSize(){
        return cellSize;
    }

    static public String getGameObjectName() {
        return "Grid";
    }

    public boolean isValidGridCoordinate(final GridCoordinates gridCoordinates) {
        return gridCoordinates.getFirst() >= 0 && gridCoordinates.getFirst() < gridInfo.getColumns()
                && gridCoordinates.getSecond() >= 0 && gridCoordinates.getSecond() < gridInfo.getRows();
    }

    public void updateCellContent(final CellContentType cellContentType, final Optional<GridCoordinates> fromGridCoordinates, final GridCoordinates toGridCoordinates) {
        fromGridCoordinates.ifPresent(gridCoordinates-> {
            final int linearIndex = GridUtil.getLinearIndex(gridCoordinates.getFirst(),gridCoordinates.getSecond(),this.gridInfo.getRows(), this.gridInfo.getColumns());
            cells[linearIndex].setContentType(CellContentType.EMPTY);
        });

        final int linearIndex = GridUtil.getLinearIndex(toGridCoordinates.getFirst(),toGridCoordinates.getSecond(),this.gridInfo.getRows(), this.gridInfo.getColumns());
        cells[linearIndex].setContentType(cellContentType);
    }

    public CellContentType getCellContentTypeAt(final GridCoordinates gridCoordinates) {
        final int linearIndex = GridUtil.getLinearIndex(gridCoordinates.getFirst(),gridCoordinates.getSecond(),this.gridInfo.getRows(), this.gridInfo.getColumns());
        return cells[linearIndex].getContentType();
    }
    @Override
    protected void update(double v) {
    }

    @Override
    protected void render(Graphics graphics) {
        graphics.drawImage(gridBackground, 0, 0, this.gridInfo.getWidth(), this.gridInfo.getHeight(), null, null);
    }
}
