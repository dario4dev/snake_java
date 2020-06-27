package entities.snake;

import engine.Engine;
import engine.GameObject;
import engine.InputListener;
import engine.systems.InputSystem;
import entities.grid.CellSize;
import entities.grid.Grid;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SnakeEntity extends GameObject implements InputListener {

    private Grid grid = null;

    public SnakeEntity(CellSize cellSize) {
        getTransform().setScale((double)cellSize.getWidth(), (double)cellSize.getHeight());
        InputSystem inputSystem = Engine.get().getSystem(InputSystem.getSystemId());
        inputSystem.addListener(this, KeyEvent.VK_A);
        inputSystem.addListener(this, KeyEvent.VK_D);
        inputSystem.addListener(this, KeyEvent.VK_W);
        inputSystem.addListener(this, KeyEvent.VK_S);

    }

    public void finalised() {
        InputSystem inputSystem = Engine.get().getSystem(InputSystem.getSystemId());
        inputSystem.removeListenerFromAllEvents(this);

    }
    @Override
    protected void update(double v) {
        List<Double> centerPos = getCenterPosition();

        System.out.println("pos_x : " + getTransform().getPositionX().intValue() + " pos_y: " + getTransform().getPositionY().intValue());

        System.out.println("getCenterPos_x : " + centerPos.get(0) + " getCenterPos_y: " + centerPos.get(1));

        if(grid == null) {
            grid = (Grid) GameObject.find(Grid.GetGameObjectName());
        }
    }

    @Override
    protected void render(Graphics graphics) {
        graphics.fillRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), getTransform().getScaleX().intValue(), getTransform().getScaleY().intValue());
        graphics.drawRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), getTransform().getScaleX().intValue(), getTransform().getScaleY().intValue());

        List<Double> centerPos = getCenterPosition();

        graphics.setColor(Color.CYAN);
        graphics.drawRect(centerPos.get(0).intValue(),centerPos.get(1).intValue(), 5, 5);
        graphics.setColor(Color.BLACK);

    }

    @Override
    public void keyPressed(Integer keyEvent) {
        if(keyEvent == KeyEvent.VK_A) {
            getTransform().setPosition(-1, 0);
            return;
        }
        if(keyEvent == KeyEvent.VK_D) {
            getTransform().setPosition(1, 0);
            return;
        }
        if(keyEvent == KeyEvent.VK_W) {
            getTransform().setPosition(0, -1);
            return;
        }
        if(keyEvent == KeyEvent.VK_S) {
            getTransform().setPosition(0, 1);
            return;
        }
    }

    @Override
    public void keyReleased(Integer keyEvent) {

    }

    private void UpdateMovement(List<Double> newPosition) {
    }

    private List<Double> getCenterPosition() {
        final double centerX = getTransform().getPositionX() + (getTransform().getScaleX()/2.0);
        final double centerY = getTransform().getPositionY() + (getTransform().getScaleY()/2.0);

        return new ArrayList<Double>() {{add(centerX); add(centerY);}};
    }
}
