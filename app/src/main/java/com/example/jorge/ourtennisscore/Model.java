package com.example.jorge.ourtennisscore;

public class Model {
    String pointsA = "0";
    String pointsB = "0";
    int gamesA = 0;
    int gamesB = 0;

    public String getPointsA() {
        return pointsA;
    }

    public String getPointsB() {
        return pointsB;
    }

    public int getGamesA() {
        return gamesA;
    }

    public int getGamesB() {
        return gamesB;
    }



    public void AScored() {
        addPoints(getPointsA(), "A");
    }

    public void BScored() {
        addPoints(getPointsB(), "B");
    }

    private void addPoints(String points, String who) {

        if (who.equals("A")){
            switch (points){
                case "0":
                    pointsA = "15";
                    break;
                case "15":
                    pointsA = "30";
                    break;
                case "30":
                    pointsA = "40";
                    break;
                case "40":
                    if (getPointsB().equals("40")){
                        pointsA = "Ad";
                        pointsB = "--";

                    }

                    else {
                        pointsA = "0";
                        pointsB = "0";
                        gamesA++;

                    }
                    break;

                case "Ad":
                    pointsA = "0";
                    pointsB = "0";
                    gamesA++;
                    break;

                case "--":
                    pointsA = "40";
                    pointsB = "40";
                    break;
            }
        }

        else if (who.equals("B")) {
            switch (points){
                case "0":
                    pointsB = "15";
                    break;
                case "15":
                    pointsB = "30";
                    break;
                case "30":
                    pointsB = "40";
                    break;
                case "40":
                    if (getPointsA().equals("40")){
                        pointsB = "Ad";
                        pointsA = "--";

                    }

                    else {
                        pointsB = "0";
                        pointsA = "0";
                        gamesB++;

                    }
                    break;

                case "Ad":
                    pointsB = "0";
                    pointsA = "0";
                    gamesB++;
                    break;

                case "--":
                    pointsB = "40";
                    pointsA = "40";
                    break;


            }
        }


    }
}
