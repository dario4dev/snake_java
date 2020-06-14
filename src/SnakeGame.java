import entities.grid.Grid;

public class SnakeGame extends Game {

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
        new Grid(5,5, 800, 600);
    }

    @Override
    public void DeinitialiseComponents() {

    }
}
