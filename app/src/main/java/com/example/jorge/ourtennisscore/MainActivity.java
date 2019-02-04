package com.example.jorge.ourtennisscore;

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
    private Button pA;
    private Button pB;
    private Button reset;
    private RadioButton bo3;
    private RadioButton bo5;

    private Presenter presenter;


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

        pA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPAPressed();

            }
        });

        pB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPBPressed();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        presenter = new Presenter( new Model(), this);




    }


    @Override
    public void displayPS(String ps1, String ps2) {

    }

    @Override
    public void displayGames(String games1, String games2) {
        this.game1.setText(games1);
        this.game2.setText(games2);

    }

    @Override
    public void displaySets(String sets1, String sets2) {

    }

    @Override
    public void displayPoints(String points1, String points2) {
        this.points1.setText(points1);
        this.points2.setText(points2);
    }
}
