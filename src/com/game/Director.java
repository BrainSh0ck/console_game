package com.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created by root on 10.04.2017.
 */
public class Director extends Former {
    private static final String ORK = "ork";
    private static final String UNDEAD = "undead";
    private static final String HUMAN = "human";
    private static final String ELF = "elf";

    //List<List> squad = new ArrayList<List>();
    //List<Unit> dark = new ArrayList<Unit>();

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
    public void setLightSquad (int race_rnd) {
        String race;
        switch (race_rnd) {
            case 1 : {race = ELF; break;}
            case 2 : {race = HUMAN; break;}
            default :  {race = ""; break;}
        }
        Runner.light.add(createMage(race));
        for (int i = 0; i <= 2; i++) {
            Runner.light.add(createArcher(race));
        }
        for (int i = 0; i <= 3; i++) {
            Runner.light.add(createWarrior(race));
        }
    }
    public void setDarkSquad (int race_rnd) {
        String race;
        switch (race_rnd) {
            case 3 : {race = ORK; break;}
            case 4 : {race = UNDEAD;break;}
            default : {race = "";break;}
        }
        Runner.dark.add(createMage(race));
        for (int i = 0; i <= 2; i++) {
            Runner.dark.add(createArcher(race));
        }
        for (int i = 0; i <= 3; i++) {
            Runner.dark.add(createWarrior(race));
        }
    }

    @Override
    public Unit createMage(String race) {

        return new Unit(race, new Mag(),new MagAction());
    }

    @Override
    public Unit createArcher(String race) {

        return new Unit(race,new Archer(),new ArchAction());
    }

    @Override
    public Unit createWarrior(String race) {
        return new Unit(race,  new Warrior(),new WarAction());
    }
}
