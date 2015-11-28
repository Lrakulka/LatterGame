package freelance.lattergame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Date;

import freelance.lattergame.pan.Pancake;
import freelance.lattergame.pan.PancakePan;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
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
        ArrayList<Pancake> pances = new ArrayList<>();
        pances.add((Pancake) findViewById(R.id.surfaceView));
        pances.add((Pancake) findViewById(R.id.surfaceView2));
        pances.add((Pancake) findViewById(R.id.surfaceView3));
        pances.add((Pancake) findViewById(R.id.surfaceView4));
        pances.add((Pancake) findViewById(R.id.surfaceView5));
        PancakePan pan = new PancakePan((RelativeLayout) findViewById(R.id.relativelayout), null);
        pan.setPancakes(pances);

    }
}
