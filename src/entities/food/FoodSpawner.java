package entities.food;

import entities.grid.GridCoordinates;
import entities.grid.GridInfo;

import java.util.Random;

public class FoodSpawner {

    private Food foodEntity = null;

    public FoodSpawner() {
        foodEntity = new Food();
    }

    public void Spawn(final GridCoordinates snakePosition, final GridInfo gridInfo){
        final int rowsFromOrigin = snakePosition.getFirst();
        final int rowsToBorder =  gridInfo.getRows() - 1 - snakePosition.getFirst();
        final int maxRowDistance = Math.max(rowsFromOrigin, rowsToBorder);

        final int columnsFromOrigin = snakePosition.getFirst();
        final int columnsToBorder = gridInfo.getRows() - 1 -snakePosition.getSecond();
        final int maxColumnDistance = Math.max(columnsFromOrigin, columnsToBorder);

        Random random = new Random();
        GridCoordinates newFoodPosition = new GridCoordinates(random.nextInt(maxRowDistance ),random.nextInt(maxColumnDistance));
        foodEntity.setPositionGridCoordinates(newFoodPosition);
    }
}
