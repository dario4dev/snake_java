package entities;

import entities.food.FoodSpawner;
import entities.grid.Grid;
import entities.grid.GridCoordinates;
import entities.snake.SnakeEntity;
import entities.snake.SnakeStatus;

public class GameLogic {

    private Grid grid;
    private SnakeEntity snakeEntity;
    private FoodSpawner foodSpawner;

    public GameLogic(final Grid grid, final SnakeEntity snake, final FoodSpawner foodSpawner) {
        this.grid = grid;
        this.snakeEntity = snake;
        this.foodSpawner = foodSpawner;

        snakeEntity.setOnStatusUpdatedCallback(new SnakeStatus() {
            @Override
            public void onStatusUpdated(SNAKE_STATUS status) {
                if(status == SNAKE_STATUS.EATING) {
                    foodSpawner.Spawn(snakeEntity.getPositionGridCoordinates(), grid.getGridInfo());
                } else if(status == SNAKE_STATUS.DEAD) {
                    Init();
                }
            }
        });

        Init();
    }

    private void Init() {
        snakeEntity.setPositionGridCoordinates(new GridCoordinates(grid.getGridInfo().getRows()/2,grid.getGridInfo().getColumns()/2));
        foodSpawner.Spawn(snakeEntity.getPositionGridCoordinates(), grid.getGridInfo());
    }
}
