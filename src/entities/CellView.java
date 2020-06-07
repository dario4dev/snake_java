package entities;
import engine.GameObject;

import java.awt.*;

public class CellView extends GameObject {

    public CellView() {
    }

    @Override
    protected void update(double v) {

    }

    @Override
    protected void render(Graphics graphics) {
        graphics.fillRect(0,0,100,100);
        graphics.drawRect(0,0,100,100);
    }
}
