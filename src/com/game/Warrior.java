package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Warrior extends Specs  {
    private static final int WAR_QUOTA = 1;

    @Override
    public String toString() {
        return String.format("%s","3");
    }


    @Override
    protected String[] setWarrior (String race) {
        String[] warrior = new String[4];
        switch (race) {
            case "ork" : { warrior[0] = "Гоблин"; warrior[1] = "20"; warrior[2]=" атаковал дубиной "; break; }
            case "undead" : { warrior[0] = "Зомби"; warrior[1] = "18"; warrior[2]=" ударил копьем "; break; }
            case "human" : { warrior[0] = "Воин человек"; warrior[1] = "18"; warrior[2]=" атаковал мечем "; break; }
            case "elf" : { warrior[0] = "Воин эльф"; warrior[1] = "15"; warrior[2]=" атаковал клинком "; break; }
        }

        return warrior;
    }

    @Override
    protected int getQuota() {
         return WAR_QUOTA;
    }
}
