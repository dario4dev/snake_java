import engine.EngineInitialiser;

public class SnakeMain {
    public static void main(String args[]) {
        //Initialise Engine
        EngineInitialiser.Init();

        //Initialise game
        SnakeGame snakeGame = new SnakeGame(new SnakeWindowProperties());
        //Initialise Game Systems
        snakeGame.InitialiseSystems();
        //Initialise Game Components
        snakeGame.InitialiseComponents();

        snakeGame.Start();
    }
}
