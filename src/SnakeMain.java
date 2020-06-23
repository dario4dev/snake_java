import engine.EngineInitialiser;

public class SnakeMain {
    public static void main(String args[]) {
        //Initialise Engine
        EngineInitialiser.init();

        //Initialise game
        SnakeGame snakeGame = new SnakeGame(new SnakeWindowProperties());
        //Initialise Game Systems
        snakeGame.initialiseSystems();
        //Initialise Game Components
        snakeGame.initialiseComponents();

        snakeGame.startGame();
    }
}
