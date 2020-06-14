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
        GetTransform().SetScale((double)cellSize.GetWidth(), (double)cellSize.GetHeight());
        InputSystem inputSystem = Engine.Get().GetSystem(InputSystem.GetSystemId());
        inputSystem.AddListener(this, KeyEvent.VK_A);
        inputSystem.AddListener(this, KeyEvent.VK_D);
    }

    public void finalised() {
        InputSystem inputSystem = Engine.Get().GetSystem(InputSystem.GetSystemId());
        inputSystem.RemoveListenerFromAllEvents(this);

    }
    @Override
    protected void Update(double v) {

    }

    @Override
    protected void Render(Graphics graphics) {
        graphics.fillRect(GetTransform().GetPositionX().intValue(),GetTransform().GetPositionY().intValue(), GetTransform().GetScaleX().intValue(), GetTransform().GetScaleY().intValue());
        graphics.drawRect(GetTransform().GetPositionX().intValue(),GetTransform().GetPositionY().intValue(), GetTransform().GetScaleX().intValue(), GetTransform().GetScaleY().intValue());
    }

    @Override
    public void KeyPressed(Integer keyEvent) {
        if(keyEvent == KeyEvent.VK_A) {
            GetTransform().SetPosition(-1, GetTransform().GetPositionY());
        }
        if(keyEvent == KeyEvent.VK_D) {
            GetTransform().SetPosition(1, GetTransform().GetPositionY());
        }
    }

    @Override
    public void KeyReleased(Integer keyEvent) {

    }
}
