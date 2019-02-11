package com.example.jorge.ourtennisscore;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IView {

    private TextView sets1;
    private TextView sets2;
    private TextView ps1;
    private TextView ps2;
    private TextView game1;
    private TextView game2;
    private TextView points1;
    private TextView points2;
    public static Button pA;
    public static Button pB;
    private Button reset;
    private RadioButton bo3;
    private RadioButton bo5;

    private Presenter presenter;



    private boolean enabled;

    public static  final String MODEL = "model";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sets1 = findViewById(R.id.sets1);
        sets2 = findViewById(R.id.sets2);
        ps1 = findViewById(R.id.ps1);
        ps2 = findViewById(R.id.ps2);
        game1 = findViewById(R.id.game1);
        game2 = findViewById(R.id.game2);
        points1 = findViewById(R.id.points1);
        points2 = findViewById(R.id.points2);
        pA = findViewById(R.id.pA);
        pB = findViewById(R.id.pB);
        reset = findViewById(R.id.reset);
        bo3 = findViewById(R.id.bo3);
        bo5 = findViewById(R.id.bo5);
        enabled = true;

        pA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPAPressed();
                if (enabled){
                    bo3.setEnabled(false);
                    bo5.setEnabled(false);
                    enabled=false;
                }

            }
        });

        pB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPBPressed();
                if (enabled){
                    bo3.setEnabled(false);
                    bo5.setEnabled(false);
                    enabled=false;
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onResetPressed();
                if (!enabled){
                    bo3.setEnabled(true);
                    bo5.setEnabled(true);
                    pA.setEnabled(true);
                    pB.setEnabled(true);
                    enabled=true;
                }

            }
        });

        bo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onBO3Pressed();


            }
        });

        bo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBO5Pressed();


            }
        });


        if (savedInstanceState == null){
            presenter = new Presenter( new Model(), this);
        }

        else {
            Model model = savedInstanceState.getParcelable(MODEL);
            presenter = new Presenter( model, this);
        }







    }

    @Override
    public void onSaveInstanceState(Bundle outState) {        //llama cuando ha de guardarse (llamadas, giro tlf)
        super.onSaveInstanceState(outState);
        presenter.saveState(outState);
    }

    @Override
    public void displayPS(String ps1, String ps2) {
        this.ps1.setText(ps1);
        this.ps2.setText(ps2);
    }

    @Override
    public void displayGames(String games1, String games2) {
        this.game1.setText(games1);
        this.game2.setText(games2);

    }

    @Override
    public void displaySets(String sets1, String sets2) {
        this.sets1.setText(sets1);
        this.sets2.setText(sets2);

    }

    @Override
    public void displayPoints(String points1, String points2) {
        this.points1.setText(points1);
        this.points2.setText(points2);
    }


}
