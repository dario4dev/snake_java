package engine;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class GameObject {

    private boolean mIsEnabled = true;
    private Transform mTransform = null;

    public GameObject() {
        mTransform = new Transform();
    }

    public boolean isEnabled() {
        return mIsEnabled;
    }

    public void setEnabled(boolean value) {
        mIsEnabled = value;
    }

    public void onUpdate(final double deltaTime) {
        if(mIsEnabled) {
            update(deltaTime);
        }
    }

    public void onRender(final Graphics graphicsDevice) {
        if(mIsEnabled) {
            render(graphicsDevice);
        }
    }

    protected abstract void update(final double deltaTime);
    protected abstract void render(final Graphics graphicsDevice);
}
