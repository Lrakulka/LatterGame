package freelance.lattergame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Date;

public class StartPage extends AppCompatActivity {
    private SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceView.setZOrderOnTop(true);    // necessary
        surfaceView.getHolder().setFormat(PixelFormat.TRANSPARENT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Rect[][] position = new Rect[4][3];
        int[][] time = new int[4][3];
        int[] rows = new int[4];
        for (int i = 0; i < position.length; ++i) {

            rows[i] = 3;
            for (int j = 0; j < position[i].length; ++j) {
                position[i][j] = new Rect(20, 20, 400, 400);
                time[i][j] = 500;
            }
        }
        final ProgrammingGif programmingGif = new ProgrammingGif(R.drawable.major, rows,
                position, time, 1000, -1);
        programmingGif.init(getResources());
        Thread thread = new Thread(new Runnable() {
            Canvas canvas;
            @Override
            public void run() {
                Date time = new Date();

                long l = time.getTime();
                while (time.getTime() - l < 1000000) {
                    time = new Date();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    canvas = surfaceView.getHolder().lockCanvas();
                    if (canvas != null) {
                        canvas.drawColor(Color.TRANSPARENT);
                        programmingGif.getWithelethetion(canvas, time.getTime());
                        surfaceView.getHolder().unlockCanvasAndPost(canvas);
                    }
                }
            }
        });
        thread.start();

    }
}
