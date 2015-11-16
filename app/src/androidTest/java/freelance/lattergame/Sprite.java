package freelance.lattergame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by asd on 16/11/15.
 * @author Lrakulka
 * Relization of sprites.
 */
public class Sprite {
    private int[] rows; // Sprite rows and columns
    private int spriteId;   // Sprite id in resources
    private Bitmap spriteBitMap;    // Bitmap of sprite
    private int spriteHeight;   // Height of one sprite image
    private int spriteWidth;    // Width of one sprite image

    public Sprite(int[] rows, int spriteId) {
        this.rows = rows;
        this.spriteId = spriteId;
    }

    /**
     * Initialized parameters of sprite
     * @param res - resources of project
     * @return true if all initialized
     */
    public boolean init(Resources res) {
        spriteBitMap = BitmapFactory.decodeResource(res, spriteId);
        spriteHeight = spriteBitMap.getHeight() / rows.length;
        spriteWidth = spriteBitMap.getWidth() / rows[0];
        if (spriteBitMap == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Draw a sprite image on a canvas.
     * @param row of a image in a sprite
     * @param column of a image in a sprite
     * @param dest position and size of sprite image in canvas
     * @param canvas container of current sprites images
     * @param paint May be null. The paint used to draw the bitmap
     * @return true if all fine alse false
     */
    public boolean drawSprite(int row, int column, final Rect dest, final Canvas canvas,
                              final Paint paint) {
        if (row > rows.length || row < 0 || rows[row] < column) {
            return false;
        }
        Rect src = new Rect(row * spriteHeight, column * spriteWidth, (1 + row) * spriteHeight,
                (1 + column) * spriteWidth);
        canvas.drawBitmap(spriteBitMap, src, dest, paint);
        return true;
    }
}
