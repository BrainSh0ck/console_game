package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Battle extends Unit {
    Battle(Races race, Arts face, Specs spec) {
        this.race = race;
        this.face = face;
        this.spec = spec;
        init();
        //if (this.face instanceof Mag) {this.face = new Mag();}
        //if (this.face instanceof Arch) {this.face = new Arch();}
        //if (this.face instanceof War) {this.face = new War();}
    }
        private void init() {
        switch (race.toString()) {
                case "1" : {
                break;}
                case "2" : {
                break;}
                case "3" : {
                break;}
                case "4" : {
                break;}
        }
        switch (spec.toString()) {
            case "1" : {
            break;}
            case "2" : {
            break;}
            case "3" : {
            break;}
        }

        }

}
