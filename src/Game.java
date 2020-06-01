import java.awt.*;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;

public class Game extends Canvas implements Runnable {

    private final int NUM_BUFFERS = 3;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final String TITLE = "Snake";
    private final Window mWindow;
    private Thread mThread;
    private boolean mIsRunning = false;

    public Game() {
        mWindow = new Window(new Dimension(WIDTH, HEIGHT), TITLE, this);
        start();
    }

    private synchronized void start() {
        if(mIsRunning) return;

        mThread = new Thread(this);
        mThread.start();
        mIsRunning = true;
    }

    private  synchronized void stop() {
        if(!mIsRunning) return;

        try {
            mThread.join();
        } catch(InterruptedException exception) {
            exception.printStackTrace();
        }
        mIsRunning = false;
    }

    @Override
    public void run() {
        this.requestFocus();
        long previousFrameTime = System.nanoTime();
        final double frameRate = 60.0;
        final double ns = 1000000000 / frameRate;
        double delta = 0.0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(mIsRunning) {
            final long currentFrameTime = System.nanoTime();
            delta += (currentFrameTime - previousFrameTime) / ns;
            previousFrameTime = currentFrameTime;
            while(delta >= 1) {
                Update();
                --delta;
            }
            Render();
            ++frames;
            if(System.currentTimeMillis() - timer > 1000) {
                timer+=1000;
                frames = 0;
            }
        }
        stop();
    }

    private void Update() {

    }

    private void Render() {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if(bufferStrategy == null) {
            createBufferStrategy(NUM_BUFFERS);
            return;
        }
        Graphics graphicsDevice = bufferStrategy.getDrawGraphics();


        bufferStrategy.show();
        graphicsDevice.dispose();
    }

    public static void main(String args[]) {
        new Game();
    }

}
