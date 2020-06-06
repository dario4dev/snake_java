import engine.Engine;
import engine.systems.GameObjectHandlerSystem;

public class SnakeMain {
    public static void main(String args[]) {
        //Initialise Engine
        Engine.Get();
        //Initialise Engine Systems
        Engine.Get().AddSystem(new GameObjectHandlerSystem());

        //Initialise game
        SnakeGame snakeGame = new SnakeGame(new SnakeWindowProperties());
        //Initialise Game Systems
        snakeGame.InitialiseSystems();
        //Initialise Game Components
        snakeGame.InitialiseComponents();

        snakeGame.Start();
    }
}
