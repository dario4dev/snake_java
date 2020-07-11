package entities.food;

import entities.grid.CellContent;
import entities.grid.CellContentType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Food extends CellContent {

    private BufferedImage foodImage;

    public Food() {
        super(CellContentType.FOOD);
        loadResources();
    }

    private void loadResources() {
        File path = new File("resources/textures");
        try {
            foodImage = ImageIO.read(new File(path, "apple.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void update(double v) {

    }

    @Override
    protected void render(Graphics graphics) {
        graphics.drawImage(foodImage, getTransform().getPositionX().intValue(),getTransform().getPositionY().intValue(), grid.getCellSize().getFirst(), grid.getCellSize().getSecond(), null, null);
    }
}
