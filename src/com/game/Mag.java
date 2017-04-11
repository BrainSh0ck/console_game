package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Mag extends Specs {
    private static final int MAGE_QUOTA = 3;
    @Override
    public String toString() {
        return String.format("%s","1");
    }
    @Override
    protected String[] setMag (String race) {
        String[] mag = new String[4];
        switch (race) {
            case "ork" : { mag[0] = "Шаман"; mag[1] = "0"; mag[2]=" наложил улучшение ";
                mag[3]=" наложил проклятье ";
                break; }
            case "undead" : { mag[0] = "Некромант"; mag[1] = "5"; mag[2]=" выстрелил магической стрелой ";
                mag[3]=" наслал недуг ";
                break; }
            case "human" : { mag[0] = "Маг"; mag[1] = "3"; mag[2]=" выстрелил стрелой огня ";
                mag[3]=" наложить улучшение ";
                break; }
            case "elf" : { mag[0] = "Маг эльф"; mag[1] = "10"; mag[2]=" выстрелил стрелой элементов ";
                mag[3]=" наложил улучшение ";
                break; }
        }

        return mag;
    }
    @Override
    protected int getQuota() {
        return MAGE_QUOTA;
    }
}
