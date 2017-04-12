package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Mag extends Specs {

    @Override
    public String toString() {
        return String.format("%s","1");
    }
    @Override
    protected String[] setMag (final String race) {
        String[] mag = new String[6];
        switch (race) {
            case Constants.ORK : { mag[0] = "Шаман"; mag[3] = "0"; mag[4]=" наложил проклятье ";
                mag[5]=" наложил улучшение ";
                break; }
            case Constants.UNDEAD : { mag[0] = "Некромант"; mag[3] = "5"; mag[4]=" выстрелил магической стрелой ";
                mag[5]=" наслал недуг ";
                break; }
            case Constants.HUMAN : { mag[0] = "Архимаг"; mag[3] = "3"; mag[4]=" выстрелил стрелой огня ";
                mag[5]=" наложить улучшение ";
                break; }
            case Constants.ELF : { mag[0] = "Маг природы"; mag[3] = "10"; mag[4]=" выстрелил стрелой элементов ";
                mag[5]=" наложил улучшение ";
                break; }
        }

        return mag;
    }

}
