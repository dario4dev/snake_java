package entities.food;

import entities.grid.CellContent;
import entities.grid.CellContentType;

import java.awt.*;

public class Food extends CellContent {


    public Food() {
        super(CellContentType.FOOD);
    }

    @Override
    protected void update(double v) {

    }

    @Override
    protected void render(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.red);

        graphics.fillRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), 5, 5);
        graphics.drawRect(getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), 5, 5);
        graphics.setColor(color);
    }
}
