import entities.grid.Grid;
import entities.snake.SnakeEntity;

public class SnakeGame extends Game {

    private Grid mGrid;
    private SnakeEntity mSnake;

    public SnakeGame(IGameWindowProperties windowProperties) {
        super(windowProperties);
    }

    @Override
    public void InitialiseSystems() {

    }

    @Override
    public void DeinitialiseSystems() {

    }

    @Override
    public void InitialiseComponents() {
        mGrid = new Grid(15,15, GetScreenScreenWidth(), GetScreenScreenHeight());
        mSnake = new SnakeEntity(mGrid.GetCellSize());
    }

    @Override
    public void DeinitialiseComponents() {

    }
}
