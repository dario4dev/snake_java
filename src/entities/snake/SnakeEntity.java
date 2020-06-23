package entities.snake;

import engine.Engine;
import engine.GameObject;
import engine.InputListener;
import engine.systems.InputSystem;
import entities.grid.CellSize;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SnakeEntity extends GameObject implements InputListener {

    public SnakeEntity(CellSize cellSize) {
        getTransform().setScale((double)cellSize.getWidth(), (double)cellSize.getHeight());
        InputSystem inputSystem = Engine.Get().getSystem(InputSystem.getSystemId());
        inputSystem.addListener(this, KeyEvent.VK_A);
        inputSystem.addListener(this, KeyEvent.VK_D);
    }

    public void finalised() {
        InputSystem inputSystem = Engine.Get().getSystem(InputSystem.getSystemId());
        inputSystem.removeListenerFromAllEvents(this);

    }
    @Override
    protected void update(double v) {

    }

    @Override
    protected void render(Graphics graphics) {
        graphics.fillRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), getTransform().getScaleX().intValue(), getTransform().getScaleY().intValue());
        graphics.drawRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), getTransform().getScaleX().intValue(), getTransform().getScaleY().intValue());
    }

    @Override
    public void keyPressed(Integer keyEvent) {
        if(keyEvent == KeyEvent.VK_A) {
            getTransform().setPosition(-1, getTransform().getPositionY());
        }
        if(keyEvent == KeyEvent.VK_D) {
            getTransform().setPosition(1, getTransform().getPositionY());
        }
    }

    @Override
    public void keyReleased(Integer keyEvent) {

    }
}
