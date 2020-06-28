package entities.snake;

import Common.ScreenCoordinates;
import engine.Engine;
import engine.InputListener;
import engine.systems.InputSystem;
import entities.grid.CellContent;
import entities.grid.CellContentType;
import entities.grid.GridCoordinates;
import entities.grid.GridUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeEntity extends CellContent implements InputListener {

    private enum MOVEMENT_DIRECTION {
        NONE,
        LEFT,
        RIGHT,
        UP,
        DOWN
    };

    private MOVEMENT_DIRECTION currentMovementDirection;
    private MOVEMENT_DIRECTION nextMovementDirection;
    private SnakeStatus statusCallback;

    private Map<MOVEMENT_DIRECTION, List<Double>> movementDirectionMap;
    private Map<Integer, MOVEMENT_DIRECTION> keyToMovementDirectionMap;
    private final float updateMovementSeconds = 1.0f;
    private float updateMovementTimerCounter = 0.0f;

    public SnakeEntity() {
        super(CellContentType.SNAKE);

        currentMovementDirection = MOVEMENT_DIRECTION.NONE;
        nextMovementDirection = currentMovementDirection;
        movementDirectionMap = new HashMap<MOVEMENT_DIRECTION, List<Double>>() {{
            put(MOVEMENT_DIRECTION.NONE, new ArrayList<Double>(){{add(0.0);add(0.0);}});
            put(MOVEMENT_DIRECTION.LEFT, new ArrayList<Double>(){{add(-1.0);add(0.0);}});
            put(MOVEMENT_DIRECTION.RIGHT, new ArrayList<Double>(){{add(1.0);add(0.0);}});
            put(MOVEMENT_DIRECTION.UP, new ArrayList<Double>(){{add(0.0);add(-1.0);}});
            put(MOVEMENT_DIRECTION.DOWN, new ArrayList<Double>(){{add(0.0);add(1.0);}});
        }};

        keyToMovementDirectionMap = new HashMap<Integer, MOVEMENT_DIRECTION>() {{
            put(KeyEvent.VK_A, MOVEMENT_DIRECTION.LEFT);
            put(KeyEvent.VK_D, MOVEMENT_DIRECTION.RIGHT);
            put(KeyEvent.VK_W, MOVEMENT_DIRECTION.UP);
            put(KeyEvent.VK_S, MOVEMENT_DIRECTION.DOWN);

            put(KeyEvent.VK_LEFT, MOVEMENT_DIRECTION.LEFT);
            put(KeyEvent.VK_RIGHT, MOVEMENT_DIRECTION.RIGHT);
            put(KeyEvent.VK_UP, MOVEMENT_DIRECTION.UP);
            put(KeyEvent.VK_DOWN, MOVEMENT_DIRECTION.DOWN);

        }};

        InputSystem inputSystem = Engine.get().getSystem(InputSystem.getSystemId());
        inputSystem.addListener(this, KeyEvent.VK_A);
        inputSystem.addListener(this, KeyEvent.VK_D);
        inputSystem.addListener(this, KeyEvent.VK_W);
        inputSystem.addListener(this, KeyEvent.VK_S);
        inputSystem.addListener(this, KeyEvent.VK_LEFT);
        inputSystem.addListener(this, KeyEvent.VK_RIGHT);
        inputSystem.addListener(this, KeyEvent.VK_UP);
        inputSystem.addListener(this, KeyEvent.VK_DOWN);
    }

    public void finalised() {
        InputSystem inputSystem = Engine.get().getSystem(InputSystem.getSystemId());
        inputSystem.removeListenerFromAllEvents(this);

    }
    @Override
    protected void update(double deltaTime) {

        if(nextMovementDirection != MOVEMENT_DIRECTION.NONE) {
            updateStatus(SnakeStatus.SNAKE_STATUS.MOVING);
            updateMovementTimerCounter += deltaTime;
            if(updateMovementTimerCounter >= updateMovementSeconds) {
                GridCoordinates updatedGridCoordinate = updateMovement(movementDirectionMap.get(nextMovementDirection));
                currentMovementDirection = nextMovementDirection;
                updateMovementTimerCounter = 0.0f;
            }
        }
    }

    @Override
    protected void render(Graphics graphics) {

        graphics.setColor(Color.black);
        graphics.fillRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), grid.getCellSize().getFirst(), grid.getCellSize().getSecond());
        graphics.drawRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), grid.getCellSize().getFirst(), grid.getCellSize().getSecond());

        List<Double> centerPos = getCenterPosition();

        graphics.setColor(Color.CYAN);
        graphics.drawRect(centerPos.get(0).intValue(),centerPos.get(1).intValue(), 5, 5);
        graphics.setColor(Color.BLACK);

    }

    @Override
    public void keyPressed(Integer keyEvent) {

        keyToMovementDirectionMap.computeIfPresent(keyEvent.intValue(), (key, value) -> {
            if(isValidMovement(value)) {
                nextMovementDirection = value;
            }
            return value;
        });
    }

    @Override
    public void keyReleased(Integer keyEvent) {

    }

    private boolean isValidMovement(final MOVEMENT_DIRECTION movementDirection) {
        if(movementDirection == currentMovementDirection) {
            return true;
        }
        final List<Double> currentMovementDirectionValue = movementDirectionMap.get(currentMovementDirection);
        final List<Double> desiredMovementDirectionValue = movementDirectionMap.get(movementDirection);

        return (Math.abs(currentMovementDirectionValue.get(0)) - Math.abs(desiredMovementDirectionValue.get(0))) != 0.0
                || (Math.abs(currentMovementDirectionValue.get(1)) - Math.abs(desiredMovementDirectionValue.get(1))) != 0.0;
    }

    private GridCoordinates updateMovement(final List<Double> newDirection) {
        final List<Double> newPosition = new ArrayList<Double>() {{
            add(getTransform().getPositionX() + newDirection.get(0) * grid.getCellSize().getFirst());
            add(getTransform().getPositionY() + newDirection.get(1) * grid.getCellSize().getSecond());
        }};
        ScreenCoordinates newPositionScreenCoordinates = new ScreenCoordinates(newPosition.get(0).intValue(), newPosition.get(1).intValue());
        GridCoordinates gridCoordinates = GridUtil.getGridCoordinateFromScreenCoordinate(newPositionScreenCoordinates, grid.getGridInfo());
        if(grid.isValidGridCoordinate(gridCoordinates)) {
            if(grid.getCellContentTypeAt(gridCoordinates) == CellContentType.FOOD) {
                updateStatus(SnakeStatus.SNAKE_STATUS.EATING);
            }
            setPositionScreenCoordinates(newPositionScreenCoordinates);
            return gridCoordinates;
        }

        updateStatus(SnakeStatus.SNAKE_STATUS.DEAD);

        return null;
    }

    private  GridCoordinates getCurrentGridCoordinate() {
        return GridUtil.getGridCoordinateFromScreenCoordinate(new ScreenCoordinates(getTransform().getPositionX().intValue(), getTransform().getPositionY().intValue()), grid.getGridInfo());
    }

    private List<Double> getCenterPosition() {
        final double centerX = getTransform().getPositionX() + (getTransform().getScaleX()/2.0);
        final double centerY = getTransform().getPositionY() + (getTransform().getScaleY()/2.0);

        return new ArrayList<Double>() {{add(centerX); add(centerY);}};
    }

    public void setOnStatusUpdatedCallback(SnakeStatus statusCallback) {
        this.statusCallback = statusCallback;
    }

    private void updateStatus(SnakeStatus.SNAKE_STATUS status) {
        if(statusCallback != null) {
            statusCallback.setStatus(status);
        }
    }
}
