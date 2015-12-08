package freelance.lattergame.progress_bar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

import freelance.lattergame.R;
import freelance.lattergame.pan.Pancake;

/**
 * Created by asd on 28/11/15.
 */
public class PancakeProgressBar extends SurfaceView implements SurfaceHolder.Callback {
    private Bitmap backGround;
    private ArrayList<Pancake> pancakes;
    private ArrayList<RectF> dsts;
    private float topShift;
    private float bottomShift;
    private float leftShift;
    private PointF pancakeSize;
    private Paint paintText;

    {
        backGround = BitmapFactory.decodeResource(getContext().getResources(),
                R.drawable.background_pancake_progress_bar);
        getHolder().addCallback(this);
    }

    public PancakeProgressBar(Context context) {
        super(context);
    }

    public PancakeProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PancakeProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (android.os.Build.VERSION.SDK_INT > 16) {
            this.setBackground(getContext().getResources().
                    getDrawable(R.drawable.background_pancake_progress_bar));
        }
        else{
            this.setBackgroundDrawable(getContext().getResources().
                    getDrawable(R.drawable.background_pancake_progress_bar));
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void setLength(int length) {
        float pancakeHeight = getHeight() - R.dimen.activity_vertical_margin * 2;
        float pancakeWeight = (getWidth() - R.dimen.activity_vertical_margin * 2) / (length *
                R.dimen.activity_vertical_margin) - R.dimen.activity_vertical_margin;
        if (pancakeHeight > pancakeWeight) {
            pancakeSize = new PointF(pancakeWeight, pancakeWeight);
        } else {
            pancakeSize = new PointF(pancakeHeight, pancakeHeight);
        }
        topShift = (getHeight() - pancakeSize.y) / 2;
        bottomShift = topShift + pancakeSize.y;
        leftShift = (getWidth() - R.dimen.activity_vertical_margin * 2) / length;
        pancakes = new ArrayList<>(length);
        dsts = new ArrayList<>(length);
        float currLeftShift = R.dimen.activity_horizontal_margin;
        for (int i = 0; i < length; ++i) {
            pancakes.add(getEmptyPancake(i));
            dsts.add(new RectF(currLeftShift +=
                    leftShift, topShift, pancakeSize.y + currLeftShift, bottomShift));
        }
        paintText = new Paint();
        paintText.setColor(Color.WHITE);
        paintText.setTextAlign(Paint.Align.CENTER);
        paintText.setTextSize(pancakeSize.x / 2);
        update();
    }

    private Pancake getEmptyPancake(final int i) {
        Pancake pancake = new Pancake(getContext()){

            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                int xPos = (canvas.getWidth() / 2);
                int yPos = (int) (canvas.getHeight() / 2); /* - ((textPaint.descent() +
                        textPaint.ascent()) / 2)) ;*/
                //((textPaint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.

                canvas.drawText(Integer.toString(i + 1), xPos, yPos, paintText);
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                // Make SurfaceView transparent
                if (android.os.Build.VERSION.SDK_INT > 16) {
                    this.setBackground(getContext().getResources().
                            getDrawable(R.drawable.pancake_plate));
                } else {
                    this.setBackgroundDrawable(getContext().getResources().
                            getDrawable(R.drawable.pancake_plate));
                }
                this.setZOrderOnTop(true);    // necessary
                holder.setFormat(PixelFormat.TRANSPARENT);
            }
        };
        return pancake;
    }

    private void update() {
        Canvas canvas = this.getHolder().lockCanvas();
        if (canvas != null) {
            canvas.drawBitmap(backGround, 0, 0, null);
            for (int i = 0; i < pancakes.size(); ++i) {
                canvas.drawBitmap(pancakes.get(i).getImager(), null, dsts.get(i), null);
            }
            this.getHolder().unlockCanvasAndPost(canvas);
        }
    }

    public void putPancakes(Pancake pancake, int position) {
        if (position >= pancakes.size() || position < 0) {
            throw new IndexOutOfBoundsException("Invalid position " + position +
                    ", must be in range 0 to " + pancakes.size());
        }
        pancakes.set(position, pancake);
        update();
    }

    public void deletePancakes(Pancake pancake, int position) {
        if (position >= pancakes.size() || position < 0) {
            throw new IndexOutOfBoundsException("Invalid position " + position +
                    ", must be in range 0 to " + pancakes.size());
        }
        pancakes.set(position, getEmptyPancake(position));
        update();
    }

    public List<Pancake> getPancakes() {
        return pancakes.subList(0, pancakes.size());
    }
}
