package freelance.lattergame.pan;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by asd on 26/11/15.
 */
public class PancakePan implements View.OnTouchListener{
    private RelativeLayout pan;
    private ArrayList<Pancake> pancakes;
    private ArrayList<PanPanDimension> panPanDimensions;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(new ViewGroup.MarginLayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        lp.setMargins(x, y, 0, 0);
        v.setLayoutParams(lp);
        return true;
    }


    public PancakePan(RelativeLayout layoutPan, ArrayList<PanPanDimension> panPanDimensions) {
        pan = layoutPan;
        this.panPanDimensions = panPanDimensions;
    }

    public void setPancakes(ArrayList<Pancake> pancakes) {
        this.pancakes = pancakes;
    }

    public ArrayList<Pancake> getPancakes() {
        return pancakes;
    }

    public void update() {
        for (Pancake pancake : pancakes) {
            pancake.update();
        }
    }
}
