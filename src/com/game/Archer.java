package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Archer extends Specs {
    private static final int ARCHER_QUOTA = 2;
    @Override
    public String toString() {
        return String.format("%s","2");
    }

    @Override
    protected String[] setArcher (String race) {
        String[] archer = new String[5];
        switch (race) {
            case "ork" : { archer[0] = "Лучник орк"; archer[1] = "3"; archer[2]="Выстрел из тяжелого лука";
            archer[3]="2"; archer[4]="Удар клинком";
            break; }
            case "undead" : { archer[0] = "Охотник"; archer[1] = "4"; archer[2]="Выстрел из проклятого лука";
            archer[3]="2";archer[4]="Атака когтями";
            break; }
            case "human" : { archer[0] = "Арбалетчик"; archer[1] = "5"; archer[2]="Выстрел из арбалета";
            archer[3]="3"; archer[4]="Атака кортиком";
            break; }
            case "elf" : { archer[0] = "Лучник эльф"; archer[1] = "7"; archer[2]="Выстрел из точного лука";
            archer[3]="3"; archer[4]="Удар с уворотом";
            break; }
        }

        return archer;
    }
    @Override
    protected int getQuota() {
        return ARCHER_QUOTA;
    }
}
