package com.example.jorge.ourtennisscore;

public class Presenter {

    Model model;

    public Presenter(Model model, IView view) {
        this.model = model;
        this.view = view;
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
    }
}
