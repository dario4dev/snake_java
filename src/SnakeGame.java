import entities.GameLogic;
import entities.food.FoodSpawner;
import entities.grid.Grid;
import entities.grid.GridInfo;
import entities.snake.SnakeEntity;

public class SnakeGame extends Game {

    GameLogic gameLogic;

    public SnakeGame(IGameWindowProperties windowProperties) {
        super(windowProperties);
    }

    @Override
    public void initialiseSystems() {

    }

    @Override
    public void deInitialiseSystems() {

    }

    @Override
    public void initialiseComponents() {
        GridInfo gridInfo = new GridInfo(15, 15, getScreenScreenWidth(), getScreenScreenHeight());
        gameLogic =   new GameLogic(new Grid(gridInfo)
                    , new SnakeEntity()
                    , new FoodSpawner(gridInfo));
    }

    @Override
    public void deInitialiseComponents() {

    }
}
