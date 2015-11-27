package freelance.lattergame.pan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by asd on 27/11/15.
 */
public class Pancake extends ImageView {
    private float positionX;
    private float positionY;

    public Pancake(Context context) {
        super(context);
    }

    public Pancake(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Pancake(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public void update() {

    }
}
