
public class SnakeWindowProperties implements IGameWindowProperties {
    @Override
    public int getNumBuffers() {
        return 3;
    }

    @Override
    public int getWidth() {
        return 600;
    }

    @Override
    public int getHeight() {
        return 640;
    }

    @Override
    public String getTitle() {
        return "Snake";
    }
}
