package freelance.lattergame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.Size;

import java.util.ResourceBundle;

/**
 * Created by asd on 16/11/15.
 * @author Lrakulka
 * Main goal of class to animate images and position its in game.
 * Exsample. We have character wich need to move in some derection with animatione in game.
 */
public class ProgrammingGif {
    int normalImage;    // Normal image. state=0
    int[] animationImagesId;    // Ids of images for animation.
    Bitmap[] animationImages; // Bitmaps of images for animation.
    PointF[] positionImages;   // Positions for each image in animation.
    Matrix[] matrixImages;   // Matrix for each image in animation. matrixImages=null image size.
    int state;          // Current state of animation. state=-1 - ProgrammingGif don't show.
    int[] timeImages;   // Time of image appering for each image in animation.
    int delayAnimation; // Time delay for animation start.
    int repeat;     // How much times repeat animation. repeat= -1 repeat.
    Paint paint;

    ProgrammingGif(int normalImage, int[] animationImagesId, PointF[] positionImages,
                   int[] timeImages, Matrix[] matrixImages, int delayAnimation, int repeat) {
        this.normalImage = normalImage;
        this.animationImagesId = animationImagesId;
        this.positionImages = positionImages;
        this.timeImages = timeImages;
        this.matrixImages = matrixImages;
        this.delayAnimation = delayAnimation;
        this.repeat = repeat;

    }

    public boolean init(Resources res) {
        if (animationImages == null) {
            return false;
        }
        animationImages = new Bitmap[animationImagesId.length + 1];
        animationImages[0] = BitmapFactory.decodeResource(res, normalImage);
        for (int i = 1; i < animationImages.length; ++i) {
            animationImages[i] = BitmapFactory.decodeResource(res, animationImagesId[i]);
        }
        paint = null;
        return true;
    }

    public void setState(int state) {
        if (state < -1) {
            this.state = -1;
            return;
        }
        if (state > (animationImages.length + 1)) {
            this.state = animationImages.length + 1;
            return;
        }
        this.state = state;
    }

    public int getWithelethetion(final Canvas canvas) {
        if (state == -1) {
            return state;
        }
        canvas.drawBitmap(animationImages[state], positionImages[state].x,
                    positionImages[state].y, paint);

        return state;
    }

}
