package entities.food;

import entities.grid.GridCoordinates;
import entities.grid.GridInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FoodSpawner {

    private Food foodEntity = null;
    private final List<GridCoordinates> gridCoordinatesList;

    public FoodSpawner(final GridInfo gridInfo) {
        gridCoordinatesList = new ArrayList<GridCoordinates>();
        for(int y = 0; y < gridInfo.getRows(); ++y) {
            for(int x = 0; x < gridInfo.getColumns(); ++x) {
                gridCoordinatesList.add(new GridCoordinates(y,x));
            }
        }
        foodEntity = new Food();
    }

    public boolean Spawn(final List<GridCoordinates> snakeBody, final GridInfo gridInfo){

        List<GridCoordinates> candidateSpawnPositions = gridCoordinatesList.stream().filter(gridCoordinates -> {
            return !snakeBody.contains(gridCoordinates);
            }).collect(Collectors.toList());

        if(candidateSpawnPositions.isEmpty()) {
            return false;
        }

        Random random = new Random();
        final int newFoodPositionIndex = random.nextInt(candidateSpawnPositions.size());
        foodEntity.setPositionGridCoordinates(candidateSpawnPositions.get(newFoodPositionIndex));
        return true;
    }
}
