package freelance.lattergame.progress_bar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by asd on 28/11/15.
 */
public class PrograssBar extends SurfaceView implements View.OnTouchListener {
    public PrograssBar(Context context) {
        super(context);
    }

    public PrograssBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PrograssBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
