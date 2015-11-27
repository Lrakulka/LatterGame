package freelance.lattergame.pan;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by asd on 27/11/15.
 */
public class PancakeMoveListener implements View.OnTouchListener {
    private float x;
    private float y;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x = event.getX();
            y = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            v.setX(v.getX() + (event.getX() - x));
            v.setY(v.getY() + (event.getY() - y));
        }
        return true;
    }
}

