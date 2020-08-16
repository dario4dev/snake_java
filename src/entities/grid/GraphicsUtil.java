package entities.grid;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class GraphicsUtil {

    public static AffineTransformOp getAffineTransformRotationOperation(Double radians, double rotationPivotX, double rotationPivotY) {
        AffineTransform affineTransform = AffineTransform.getRotateInstance(radians, rotationPivotX, rotationPivotY);
        AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
        return affineTransformOp;
    }
}
