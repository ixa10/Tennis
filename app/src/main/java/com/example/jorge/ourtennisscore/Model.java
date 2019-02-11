package com.example.jorge.ourtennisscore;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
    String pointsA = "0";
    String pointsB = "0";
    int gamesA = 0;
    int gamesB = 0;
    int setsA = 0;
    int setsB = 0;
    String ps1 = "____";
    String ps2 = "____";
    int maxSets = 3;
    int contador = 0;
    boolean pAenabled = true;
    boolean pBenabled = true;


    protected Model(Parcel in) {
        pointsA = in.readString();
        pointsB = in.readString();
        gamesA = in.readInt();
        gamesB = in.readInt();
        setsA = in.readInt();
        setsB = in.readInt();
        ps1 = in.readString();
        ps2 = in.readString();
        maxSets = in.readInt();
        contador = in.readInt();
        //pAenabled = in.readBoolean
    }

    public Model (){
        //se podría poner los atributos iniciales si son distintos de 0
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pointsA);
        dest.writeString(pointsB);
        dest.writeInt(gamesA);
        dest.writeInt(gamesB);
        dest.writeInt(setsA);
        dest.writeInt(setsB);
        dest.writeString(ps1);
        dest.writeString(ps2);
        dest.writeInt(maxSets);
        dest.writeInt(contador);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

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

    public int getSetsA() {
        return setsA;
    }

    public int getSetsB() {
        return setsB;
    }

    public String getPs1() {
        return ps1;
    }

    public String getPs2() {
        return ps2;
    }



    public void AScored() {
        addPoints(getPointsA(), "A");
    }

    public void BScored() {
        addPoints(getPointsB(), "B");
    }

    private void addPoints(String points, String who) {

        if (who.equals("A")){
            if (gamesA < 6 || gamesB < 6){
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
                            //gamesA++;
                            addGames(getGamesA(),"A");

                        }
                        break;

                    case "Ad":
                        pointsA = "0";
                        pointsB = "0";
                        addGames(getGamesA(),"A");
                        break;

                    case "--":
                        pointsA = "40";
                        pointsB = "40";
                        break;
                }
            }

            else {
                int numA = Integer.parseInt(getPointsA());
                int numB = Integer.parseInt(getPointsB());
                if (numA < 6){
                    numA++;
                    pointsA = numA+"";
                }

                else if (numA > numB){
                    gamesA++;
                    addSets(getSetsA(), "A");
                    pointsA = "0";
                    pointsB = "0";
                    gamesA=0;
                    gamesB=0;

                }

                else {
                    numA++;
                    pointsA = numA+"";
                }
            }


        }


        else if (who.equals("B")) {
            if (gamesA < 6 || gamesB <6){
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
                            addGames(getGamesB(),"B");

                        }
                        break;

                    case "Ad":
                        pointsB = "0";
                        pointsA = "0";
                        addGames(getGamesB(),"B");
                        break;

                    case "--":
                        pointsB = "40";
                        pointsA = "40";
                        break;


                }
            }

            else {
                int numA = Integer.parseInt(getPointsA());
                int numB = Integer.parseInt(getPointsB());
                if (numB < 6){
                    numB++;
                    pointsB = numB+"";
                }

                else if (numB > numA){
                    gamesB++;
                    addSets(getSetsB(), "B");
                    pointsA = "0";
                    pointsB = "0";
                    gamesA=0;
                    gamesB=0;

                }

                else {
                    numB++;
                    pointsB = numB+"";
                }
            }
        }



    }

    private void addGames (int games, String who){
        if (who.equals("A")){
            if (games<5){
                gamesA++;
            }

            else if (games > getGamesB()){
                gamesA++;
                addSets(getSetsA(), "A");
                gamesA=0;
                gamesB=0;


            }

            else {
                gamesA++;
            }

        }

        else if (who.equals("B")){
            if (games < 5){
                gamesB++;
            }

            else if (games > getGamesA()){
                gamesB++;
                addSets(getSetsB(), "B");
                gamesA=0;
                gamesB=0;


            }

            else {
                gamesB++;
            }

        }

    }

    private void addSets (int sets, String who){        //pasar previous sets
        if (who.equals("A")){
            if (sets < maxSets){
                setsA++;
                contador++;
                if (maxSets == 3){
                    switch (contador){
                        case 1:
                            ps1 = getGamesA() + "___";
                            ps2 = getGamesB() + "___";
                            break;

                        case 2:
                            ps1 = ps1.substring(0,1) + getGamesA() + "__";
                            ps2 = ps2.substring(0,1) + getGamesB() + "__";
                            break;

                        case 3:
                            ps1 = ps1.substring(0,2) + getGamesA() + "_";
                            ps2 = ps2.substring(0,2) + getGamesB() + "_";
                            break;

                        case 4:
                            ps1 = ps1.substring(0,3) + getGamesA() + "";
                            ps2 = ps2.substring(0,3) + getGamesB() + "";
                            break;

                        case 5:
                            ps1 = ps1.substring(0,4) + getGamesA() + "";
                            ps2 = ps2.substring(0,4) + getGamesB() + "";
                            break;
                    }
                }

                else if (maxSets == 2){
                    switch (contador){
                        case 1:
                            ps1 = getGamesA() + "_";
                            ps2 = getGamesB() + "_";
                            break;

                        case 2:
                            ps1 = ps1.substring(0,1) + getGamesA() + "";
                            ps2 = ps2.substring(0,1) + getGamesB() + "";
                            break;

                        case 3:
                            ps1 = ps1.substring(0,2) + getGamesA() + "";
                            ps2 = ps2.substring(0,2) + getGamesB() + "";
                            break;


                    }

                }

                if (setsA >= maxSets){
                    MainActivity.pA.setEnabled(false);
                    MainActivity.pB.setEnabled(false);

                }
            }



        }

        if (who.equals("B")){
            if (sets < maxSets){
                setsB++;
                contador++;
                if (maxSets == 3){
                    switch (contador){
                        case 1:
                            ps1 = getGamesA() + "___";
                            ps2 = getGamesB() + "___";
                            break;

                        case 2:
                            ps1 = ps1.substring(0,1) + getGamesA() + "__";
                            ps2 = ps2.substring(0,1) + getGamesB() + "__";
                            break;

                        case 3:
                            ps1 = ps1.substring(0,2) + getGamesA() + "_";
                            ps2 = ps2.substring(0,2) + getGamesB() + "_";
                            break;

                        case 4:
                            ps1 = ps1.substring(0,3) + getGamesA() + "";
                            ps2 = ps2.substring(0,3) + getGamesB() + "";
                            break;

                        case 5:
                            ps1 = ps1.substring(0,4) + getGamesA() + "";
                            ps2 = ps2.substring(0,4) + getGamesB() + "";
                            break;
                    }
                }

                else if (maxSets == 2){
                    switch (contador){
                        case 1:
                            ps1 = getGamesA() + "_";
                            ps2 = getGamesB() + "_";
                            break;

                        case 2:
                            ps1 = ps1.substring(0,1) + getGamesA() + "";
                            ps2 = ps2.substring(0,1) + getGamesB() + "";
                            break;

                        case 3:
                            ps1 = ps1.substring(0,2) + getGamesA() + "";
                            ps2 = ps2.substring(0,2) + getGamesB() + "";
                            break;


                    }

                }
                if (setsB >= maxSets){
                    MainActivity.pA.setEnabled(false);
                    MainActivity.pB.setEnabled(false);

                }
            }

        }
    }

    public void BO3Pressed() {
        ps1 = "__";
        ps2 = "__";
        maxSets = 2;
    }

    public void BO5Pressed() {
        ps1 = "____";
        ps2 = "____";
        maxSets = 3;
    }

    public void ResetPressed() {
        if (maxSets == 2){
            pointsA = "0";
            pointsB = "0";
            gamesA = 0;
            gamesB = 0;
            setsA = 0;
            setsB = 0;
            ps1 = "__";
            ps2 = "__";
            contador =0;
        }

        else {
            pointsA = "0";
            pointsB = "0";
            gamesA = 0;
            gamesB = 0;
            setsA = 0;
            setsB = 0;
            ps1 = "____";
            ps2 = "____";
            contador =0;
        }


    }
}
