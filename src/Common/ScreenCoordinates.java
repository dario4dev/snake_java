package Common;

import entities.grid.Pair;

public class ScreenCoordinates extends Pair<Integer> {

    public ScreenCoordinates(final Integer x, final Integer y) {
        super(x, y);
    }

    public ScreenCoordinates() {
        super(0, 0);
    }
}
