package entities.snake;

public abstract class SnakeStatus {
    public enum SNAKE_STATUS {
        IDLE,
        MOVING,
        EATING,
        DEAD
    };

    public SnakeStatus() {
        setStatus(SNAKE_STATUS.IDLE);
    }
    private SNAKE_STATUS status;

    public SNAKE_STATUS getStatus() {
        return status;
    }

    public void setStatus(final SNAKE_STATUS status) {
        this.status = status;
        onStatusUpdated(status);
    }

    public abstract void onStatusUpdated(SNAKE_STATUS status);
}
