package entities.snake;

import Common.ScreenCoordinates;
import engine.Engine;
import engine.GameObject;
import engine.InputListener;
import engine.systems.InputSystem;
import entities.grid.CellSize;
import entities.grid.Grid;
import entities.grid.GridCoordinates;
import entities.grid.GridUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SnakeEntity extends GameObject implements InputListener {

    private Grid grid = null;

    public SnakeEntity(CellSize cellSize) {

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

        //System.out.println("pos_x : " + getTransform().getPositionX().intValue() + " pos_y: " + getTransform().getPositionY().intValue());

        //System.out.println("getCenterPos_x : " + centerPos.get(0) + " getCenterPos_y: " + centerPos.get(1));
    }

    @Override
    protected void render(Graphics graphics) {
        if(grid == null) {
            grid = (Grid) GameObject.find(Grid.getGameObjectName());
        }
        graphics.fillRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), grid.getCellSize().getFirst(), grid.getCellSize().getSecond());
        graphics.drawRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), grid.getCellSize().getFirst(), grid.getCellSize().getSecond());

        List<Double> centerPos = getCenterPosition();

        graphics.setColor(Color.CYAN);
        graphics.drawRect(centerPos.get(0).intValue(),centerPos.get(1).intValue(), 5, 5);
        graphics.setColor(Color.BLACK);

    }

    @Override
    public void keyPressed(Integer keyEvent) {
        if(keyEvent == KeyEvent.VK_A) {
            updateMovement( new ArrayList<Double>(){ {add(getTransform().getPositionX() - grid.getCellSize().getFirst()); add(getTransform().getPositionY());}});
            return;
        }
        if(keyEvent == KeyEvent.VK_D) {
            updateMovement( new ArrayList<Double>(){ {add(getTransform().getPositionX() + grid.getCellSize().getFirst()); add(getTransform().getPositionY());}});
            return;
        }
        if(keyEvent == KeyEvent.VK_W) {
            updateMovement( new ArrayList<Double>(){ {add(getTransform().getPositionX()); add(getTransform().getPositionY() - grid.getCellSize().getFirst());}});
            return;
        }
        if(keyEvent == KeyEvent.VK_S) {
            updateMovement( new ArrayList<Double>(){ {add(getTransform().getPositionX()); add(getTransform().getPositionY() + grid.getCellSize().getFirst());}});
            return;
        }
    }

    @Override
    public void keyReleased(Integer keyEvent) {

    }

    private void updateMovement(List<Double> newPosition) {
        GridCoordinates gridCoordinates = GridUtil.getGridCoordinateFromScreenCoordinate(new ScreenCoordinates(newPosition.get(0).intValue(), newPosition.get(1).intValue()), grid.getGridInfo());
        if(grid.isValidGridCoordinate(gridCoordinates)) {
            getTransform().setPosition(newPosition);
        }
    }

    private List<Double> getCenterPosition() {
        final double centerX = getTransform().getPositionX() + (getTransform().getScaleX()/2.0);
        final double centerY = getTransform().getPositionY() + (getTransform().getScaleY()/2.0);

        return new ArrayList<Double>() {{add(centerX); add(centerY);}};
    }
}
