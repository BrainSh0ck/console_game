package com.game;

import java.util.Random;

/**
 * Created by root on 10.04.2017.
 */
public class Director extends Former {
    public void MakeSquads() {

        switch (random(4,1)) {
            case 1 : {setLightSquad(1); setDarkSquad(random(4,3)); break; }
            case 2 : {setLightSquad(2); setDarkSquad(random(4,3)); break; }
            case 3 : {setDarkSquad(3); setLightSquad(random(2,1)); break; }
            case 4 : {setDarkSquad(4); setLightSquad(random(2,1)); break; }
        }

    }

    public int random(final int max, final int min) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    public void setLightSquad (final int race_rnd) {
        String race;
        switch (race_rnd) {
            case 1 : {race = Constants.ELF; break;}
            case 2 : {race = Constants.HUMAN; break;}
            default :  {race = ""; break;}
        }
        Runner.light_full.add(createMage(race));
        for (int i = 0; i <= 2; i++) {
            Runner.light_full.add(createArcher(race));
        }
        for (int i = 0; i <= 3; i++) {
            Runner.light_full.add(createWarrior(race));
        }
    }
    public void setDarkSquad (final int race_rnd) {
        String race;
        switch (race_rnd) {
            case 3 : {race = Constants.ORK; break;}
            case 4 : {race = Constants.UNDEAD;break;}
            default : {race = "";break;}
        }
        Runner.dark_full.add(createMage(race));
        for (int i = 0; i <= 2; i++) {
            Runner.dark_full.add(createArcher(race));
        }
        for (int i = 0; i <= 3; i++) {
            Runner.dark_full.add(createWarrior(race));
        }
    }

    @Override
    public Unit createMage(final String race) {

        return new Unit(race, new Mag());
    }

    @Override
    public Unit createArcher(final String race) {

        return new Unit(race,new Archer());
    }

    @Override
    public Unit createWarrior(final String race) {

        return new Unit(race,  new Warrior());
    }
}
