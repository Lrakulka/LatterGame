package freelance.lattergame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;

import java.util.ArrayList;

import freelance.lattergame.pan.Pancake;
import freelance.lattergame.pan.PancakeMoveListener;
import freelance.lattergame.pan.PancakePan;

public class StartPage extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_page);
        AbsoluteLayout layout = (AbsoluteLayout) findViewById(R.id.absolute);
        ArrayList<Pancake> pancakes = new ArrayList<>();
        pancakes.add((Pancake) findViewById(R.id.Pancake));
        pancakes.add((Pancake) findViewById(R.id.Pancake5));
        pancakes.add((Pancake) findViewById(R.id.Pancake2));
        pancakes.add((Pancake) findViewById(R.id.Pancake3));
        pancakes.add((Pancake) findViewById(R.id.Pancake4));
        PancakePan pan = new PancakePan(layout, null);
        pan.setPancakes(pancakes);
    }
}