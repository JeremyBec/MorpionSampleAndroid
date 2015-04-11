package bbprojects.com.morpionjuniorandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int joueur = 1;
    int[] gameState = {0,0,0,0,0,0,0,0,0};
    int[][] combinaisonsGagnantes = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2, 4, 6}};
    boolean gagner = false;
    TextView labelJoueur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelJoueur = (TextView) findViewById(R.id.labelJoueur);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void caseTouched(View caseSelected) {
        if (gagner == false ) {
            ImageButton leBouton = (ImageButton) caseSelected;
            if (joueur == 1) {
                leBouton.setBackgroundResource(R.drawable.rond);
                labelJoueur.setText("Tour du Joueur 2");
                joueur = 2;
            } else {
                leBouton.setBackgroundResource(R.drawable.croix);
                labelJoueur.setText("Tour du joueur 1");
                joueur = 1;
            }
        }
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
}
