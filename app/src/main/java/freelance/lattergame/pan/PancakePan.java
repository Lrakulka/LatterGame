package freelance.lattergame.pan;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by asd on 26/11/15.
 */
public class PancakePan extends PanPanDimension {
    private ViewGroup pan;
    private ArrayList<Pancake> pancakes;
    private ArrayList<PanPanDimension> panPanDimensions;

    public PancakePan(ViewGroup layoutPan,
                      ArrayList<PanPanDimension> panPanDimensions) {
        super(layoutPan.getTop(), layoutPan.getRight(), layoutPan.getLeft(), layoutPan.getBottom());
        pan = layoutPan;
        this.panPanDimensions = panPanDimensions;
    }

    public void setPancakes(ArrayList<Pancake> pancakes) {
        this.pancakes = pancakes;
        for (Pancake pancake : pancakes) {
            pancake.setOnTouchListener(new PancakeMoveListener(this, panPanDimensions));
        }
    }

    public ArrayList<Pancake> getPancakes() {
        return pancakes;
    }

    public void update() {
        for (Pancake pancake : pancakes) {
            pancake.update();
        }
    }

    @Override
    public void flipPancake(Pancake pancake) {
        if (pancake.getPositionX() < 0) {
            pancake.setPositionX(0);
        }
        if (pancake.getPositionY() < 0) {
            pancake.setPositionY(0);
        }
        if (pancake.getPositionX() + pancake.getWidth() > pan.getWidth()) {
            pancake.setPositionX(pan.getWidth() - pancake.getWidth());
        }
        if (pancake.getPositionY() + pancake.getHeight() > pan.getHeight()) {
            pancake.setPositionY(pan.getHeight() - pancake.getHeight());
        }
    }
}
