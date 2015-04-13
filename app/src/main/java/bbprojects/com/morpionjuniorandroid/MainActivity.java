package bbprojects.com.morpionjuniorandroid;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    int joueur = 1;
    int[] gameState = {0,0,0,0,0,0,0,0,0};
    int[][] combinaisonsGagnantes = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2, 4, 6}};
    boolean gagner = false;
    TextView labelJoueur;
    ImageButton case1;
    ImageButton case2;
    ImageButton case3;
    ImageButton case4;
    ImageButton case5;
    ImageButton case6;
    ImageButton case7;
    ImageButton case8;
    ImageButton case9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelJoueur = (TextView) findViewById(R.id.labelJoueur);
        case1 = (ImageButton)findViewById(R.id.case1);
        case2 = (ImageButton)findViewById(R.id.case2);
        case3 = (ImageButton)findViewById(R.id.case3);
        case4 = (ImageButton)findViewById(R.id.case4);
        case5 = (ImageButton)findViewById(R.id.case5);
        case6 = (ImageButton)findViewById(R.id.case6);
        case7 = (ImageButton)findViewById(R.id.case7);
        case8 = (ImageButton)findViewById(R.id.case8);
        case9 = (ImageButton)findViewById(R.id.case9);
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
            gameState[Integer.valueOf(leBouton.getTag().toString())] = joueur;
            for (int i=0; i<=7; i++) {
                if(gameState[combinaisonsGagnantes[i][0]] == joueur && gameState[combinaisonsGagnantes[i][1]] == joueur && gameState[combinaisonsGagnantes[i][2]] == joueur) {
                    gagner = true;
                }
            }
            if (gagner) {
                if (joueur == 2) {
                    labelJoueur.setText("Le joueur 1 a gagné");
                } else {
                    labelJoueur.setText("Le joueur 2 a gagné");
                }
            }
        }
    }
    public void restartJeu(View boutonCourant) {
        gameState = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gagner = false;
        case1.setBackgroundResource(R.drawable.blank);
        case2.setBackgroundResource(R.drawable.blank);
        case3.setBackgroundResource(R.drawable.blank);
        case4.setBackgroundResource(R.drawable.blank);
        case5.setBackgroundResource(R.drawable.blank);
        case6.setBackgroundResource(R.drawable.blank);
        case7.setBackgroundResource(R.drawable.blank);
        case8.setBackgroundResource(R.drawable.blank);
        case9.setBackgroundResource(R.drawable.blank);
        labelJoueur.setText("Au tour du joueur 1");
        joueur = 1;
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
