package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Warrior extends Specs  {

    @Override
    public String toString() {
        return String.format("%s","3");
    }


    @Override
    protected String[] setWarrior (final String race) {
        String[] warrior = new String[4];
        switch (race) {
            case Constants.ORK : { warrior[0] = "Гоблин"; warrior[1] = "20"; warrior[2]=" атаковал дубиной "; break; }
            case Constants.UNDEAD : { warrior[0] = "Зомби"; warrior[1] = "18"; warrior[2]=" ударил копьем "; break; }
            case Constants.HUMAN : { warrior[0] = "Воин человек"; warrior[1] = "18"; warrior[2]=" атаковал мечем "; break; }
            case Constants.ELF : { warrior[0] = "Воин эльф"; warrior[1] = "15"; warrior[2]=" атаковал клинком "; break; }
        }

        return warrior;
    }

}
