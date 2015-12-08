package freelance.lattergame.pan;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import freelance.lattergame.R;

/**
 * Created by asd on 27/11/15.
 */
public class Pancake extends SurfaceView implements SurfaceHolder.Callback {
    private float positionX;
    private float positionY;
    private Bitmap bitmap;

    {
        getHolder().addCallback(this);
    }

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

    public Bitmap getImager() { // To Do - finish it
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(this.getWidth(),
                    this.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(Color.GREEN);
        }
        return bitmap;
    }

    public void update() {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Make SurfaceView transparent
        if (android.os.Build.VERSION.SDK_INT > 16) {
            this.setBackground(getContext().getResources().getDrawable(R.drawable.pancake_plate));
        } else {
            this.setBackgroundDrawable(getContext().getResources().
                    getDrawable(R.drawable.pancake_plate));
        }
        this.setZOrderOnTop(true);    // necessary
        holder.setFormat(PixelFormat.TRANSPARENT);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
