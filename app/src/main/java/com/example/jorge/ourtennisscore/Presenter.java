package com.example.jorge.ourtennisscore;

import android.os.Bundle;

public class Presenter {

    Model model;

    public Presenter(Model model, IView view) {
        this.model = model;
        this.view = view;
        updateScore();
    }

    IView view;



    public void onPAPressed() {
        model.AScored();
        updateScore();
    }

    public void onPBPressed() {
        model.BScored();
        updateScore();
    }

    private void updateScore() {
        view.displayPoints(model.getPointsA(), model.getPointsB());
        view.displayGames(model.getGamesA()+"", model.getGamesB()+"");
        view.displaySets(model.getSetsA()+"", model.getSetsB()+"");
        view.displayPS(model.getPs1()+"", model.getPs2()+"");
    }

    public void onBO3Pressed() {
        model.BO3Pressed();
        updateScore();
    }

    public void onBO5Pressed() {
        model.BO5Pressed();
        updateScore();
    }

    public void onResetPressed() {
        model.ResetPressed();
        updateScore();
    }

    public void saveState(Bundle outState) {
        outState.putParcelable(MainActivity.MODEL, model);
    }
}
