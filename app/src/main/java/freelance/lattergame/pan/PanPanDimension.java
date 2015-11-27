package freelance.lattergame.pan;

import android.view.View;

/**
 * Created by asd on 26/11/15.
 */
public abstract class PanPanDimension {
    private int top;
    private int right;
    private int left;
    private int bottom;
    private int centerX;
    private int centerY;
    
    public PanPanDimension(int top, int right, int left, int bottom) {
        this.top = top;
        this.right = right;
        this.left = left;
        this.bottom = bottom;
        centerX = (top + right) / 2;
        centerY = (bottom + left) / 2;
    }

    public boolean isIn(Pancake pancake) {
        if (top > pancake.getTop() && right > pancake.getRight() &&
                left < pancake.getLeft() && bottom < pancake.getBottom()) {
            return true;
        }
        return false;
    }

    public int getDistance(Pancake pancake) {
        return (int) Math.sqrt(centerX * ((pancake.getTop() + pancake.getRight()) / 2) +
                centerY * ((pancake.getBottom() + pancake.getLeft()) / 2));
    }

    public abstract void flipPancake(Pancake pancake);
}
