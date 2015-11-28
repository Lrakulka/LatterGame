package freelance.lattergame.animation;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by asd on 16/11/15.
 * @author Lrakulka
 * Main goal of class to animate images and position its in game.
 * Exsample. We have character wich need to move in some derection with animatione in game.
 */
public class ProgrammingGif {
    private Sprite sprite;    // Sprite of images for animation.
    private int spriteId;    // Sprite indicator in resource.
    private Rect[][] positionImages;   // Positions for each image in animation.
    private int[][] timeImages;   // Time of image appering for each image in animation.
    private int delayAnimation; // Time delay for animation start.
    private int repeat;     // How much times repeat animation. repeat= -1 repeat.
    private int[] rows;     // Contains rows and columns of sprite.
    private boolean isShow;
    private int currRow;
    private int currCol;
    private long privTime;
    private int curDelay;
    private Paint paint;


    ProgrammingGif(int spriteId, int[] rows, Rect[][] positionImages, int[][] timeImages,
                   int delayAnimation, int repeat) {
        this.spriteId = spriteId;
        this.positionImages = positionImages;
        this.timeImages = timeImages;
        this.delayAnimation = delayAnimation;
        this.repeat = repeat;
        this.rows = rows;
    }

    public void init(Resources res) {
        sprite = new Sprite(rows, spriteId);
        sprite.init(res);
        isShow = true;
        paint = null;
        curDelay = delayAnimation;
    }

    public void setFrame(int row, int col) {
        this.currCol = col;
        this.currRow = row;
    }

    public void getWithelethetion(final Canvas canvas, long time) {
        if (isShow) {
            sprite.drawSprite(currRow, currCol, positionImages[currRow][currCol], canvas, paint);
            if (repeat != 0 && time - privTime > timeImages[currRow][currCol] + curDelay) {
                currCol++;
                curDelay = 0;
                if (currCol == rows[currRow]) {
                    currCol = 0;
                    currRow++;
                }
                if (currRow == rows.length) {
                    currRow = 0;
                    curDelay = delayAnimation;
                    if (repeat > 0) {
                        repeat--;
                    }
                }
                privTime = time;
            }
        }
    }

}
