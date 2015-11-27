package freelance.lattergame.pan;

import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by asd on 27/11/15.
 */
public class PancakeMoveListener implements View.OnTouchListener {
    private float x;
    private float y;
    private PanPanDimension mainPanDimension;
    private ArrayList<PanPanDimension> panPanDimensions;

    public PancakeMoveListener(PanPanDimension mainPanDimension,
                               @Nullable ArrayList<PanPanDimension> panPanDimensions) {
        this.mainPanDimension = mainPanDimension;
        this.panPanDimensions = panPanDimensions;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Pancake pancake = (Pancake) v;
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x = event.getX();
            y = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            pancake.setPositionX(pancake.getX() + (event.getX() - x));
            pancake.setPositionY(pancake.getY() + (event.getY() - y));
            if (panPanDimensions != null) {
                for (PanPanDimension panPanDimension : panPanDimensions) {
                    panPanDimension.flipPancake(pancake);
                }
            }
            mainPanDimension.flipPancake(pancake);
            pancake.setX(pancake.getPositionX());
            pancake.setY(pancake.getPositionY());
        }
        return true;
    }
}

