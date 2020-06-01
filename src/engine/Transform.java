package engine;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Transform {

    public class DIMENSION_2D {
        public static final int X = 0;
        public static final int Y = 1;
    }

    private AffineTransform mAffineTransform;
    private ArrayList<Double> mPosition2D;
    private ArrayList<Double> mScale2D;

    public Transform(){
        mAffineTransform = new AffineTransform();
        mPosition2D = new ArrayList<>(2);
    }

    // Getter/Setter Translation
    public ArrayList<Double> getPosition2D() {
        mPosition2D.set(DIMENSION_2D.X, mAffineTransform.getTranslateX());
        mPosition2D.set(DIMENSION_2D.Y, mAffineTransform.getTranslateY());

        return mPosition2D;
    }

    public Double getPositionX() {
        return mAffineTransform.getTranslateX();
    }

    public Double getPositionY() {
        return mAffineTransform.getTranslateY();
    }

    public void setPosition(final double x, final double y) {
        mAffineTransform.setToTranslation(x, y);
    }

    public void setPositionX(final double x) {
        mAffineTransform.setToTranslation(x, mAffineTransform.getTranslateY());
    }

    public void setPositionY(final double y) {
        mAffineTransform.setToTranslation(mAffineTransform.getTranslateX(), y);
    }

    public void setPosition(final ArrayList<Double> position2D) {
        mAffineTransform.setToTranslation(position2D.get(DIMENSION_2D.X), position2D.get(DIMENSION_2D.Y));
    }

    //Getter setter Scale
    public ArrayList<Double> getScale() {
        mScale2D.set(DIMENSION_2D.X, mAffineTransform.getScaleX());
        mScale2D.set(DIMENSION_2D.Y, mAffineTransform.getScaleY());
        return mScale2D;
    }

    public Double getScaleX() {
        return mAffineTransform.getScaleX();
    }

    public Double getScaleY() {
        return mAffineTransform.getScaleY();
    }

    public void setScale(final Double x, final Double y) {
        mAffineTransform.setToScale(x, y);
    }

    public void setScaleX(final Double x) {
        mAffineTransform.setToScale(x, mAffineTransform.getScaleY());
    }

    public void setScaleY(final Double y) {
        mAffineTransform.setToScale(mAffineTransform.getScaleX(), y);
    }

    public void setScale(final ArrayList<Double> scale2D) {
        mAffineTransform.setToScale(scale2D.get(DIMENSION_2D.X), scale2D.get(DIMENSION_2D.Y));
    }

    //Getter/Setter Rotations Todo @Dario later.
}
