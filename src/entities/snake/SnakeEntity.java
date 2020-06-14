package entities.snake;

import engine.GameObject;
import entities.grid.CellSize;

import java.awt.*;

public class SnakeEntity extends GameObject {

    public SnakeEntity(CellSize cellSize) {
        GetTransform().setScale((double)cellSize.GetWidth()/2, (double)cellSize.GetHeight()/2);
    }
    @Override
    protected void update(double v) {

    }

    @Override
    protected void render(Graphics graphics) {
        graphics.fillRect(GetTransform().getPositionX().intValue(),GetTransform().getPositionY().intValue(), GetTransform().getScaleX().intValue(), GetTransform().getScaleY().intValue());
        graphics.drawRect(GetTransform().getPositionX().intValue(),GetTransform().getPositionY().intValue(), GetTransform().getScaleX().intValue(), GetTransform().getScaleY().intValue());
    }
}
