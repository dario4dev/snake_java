import entities.grid.Grid;
import entities.grid.GridInfo;
import entities.snake.SnakeEntity;

public class SnakeGame extends Game {

    private Grid grid;
    private SnakeEntity snake;

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
        grid = new Grid(new GridInfo(15, 15, getScreenScreenWidth(), getScreenScreenHeight()));
        snake = new SnakeEntity(grid.getCellSize());
    }

    @Override
    public void deInitialiseComponents() {

    }
}
