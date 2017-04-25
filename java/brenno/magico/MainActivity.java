package brenno.magico;

import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.*;
import android.view.View;

import java.io.BufferedReader;
import java.util.Random;
import android.os.Handler;
import android.view.animation.*;

public class MainActivity extends AppCompatActivity {

    private ImageButton chose_btn;
    private TextView tse;
    private ImageView rnd_card;
    private Button next;
    private LinearLayout fnal;
    private LinearLayout shuffle;
    private Button acerto;

    /***
    String[] naips = {"Copas", "Espada", "Ouro", "Paus"};
    String[] carta = {"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei"};

    // Implementing Fisher–Yates shuffle
    // Isso Fodendo Funcionaa!!!!
    // N desacredita tio

    static void shuffleArray(String[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    ***/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chose_btn = (ImageButton) findViewById(R.id.chose_btn);
        rnd_card = (ImageView) findViewById(R.id.card);
        next = (Button) findViewById(R.id.next);
        fnal = (LinearLayout) findViewById(R.id.fnal);

        acerto = (Button) findViewById(R.id.acerto);

        tse = (TextView) findViewById(R.id.chose);

        shuffle = (LinearLayout) findViewById(R.id.shuffle);

        chose_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();

                String uri = String.format("brenno.magico:drawable/c%2d", rnd.nextInt(52) + 1);
                int id = getResources().getIdentifier(uri, null, null);


                /***
                AlertDialog.Builder tst = new AlertDialog.Builder(MainActivity.this);
                tst.setMessage(uri + " " + String.valueOf(id));
                tst.show();
                 ***/

                //rnd_card.setText(carta[rnd.nextInt(carta.length)] + " de " + naips[rnd.nextInt(naips.length)]);
                rnd_card.setImageResource(id);
                rnd_card.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);

                chose_btn.setVisibility(View.GONE);

                tse.setText("Memorize a sua carta");


            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                tse.setVisibility(View.GONE);
                rnd_card.setVisibility(View.GONE);
                next.setVisibility(View.GONE);

                shuffle.setVisibility(View.VISIBLE);

                Runnable r = new Runnable() {
                    @Override
                    public void run(){
                        Random rnd = new Random();

                        shuffle.setVisibility(View.GONE);

                        fnal.setVisibility(View.VISIBLE);
                    }
                };

                Handler h = new Handler();
                h.postDelayed(r, 4500); // <-- the "1000" is the delay time in miliseconds.

            }
        });

        acerto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

    }
}
