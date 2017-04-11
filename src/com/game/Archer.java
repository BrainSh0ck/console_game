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
            case "ork" : { archer[0] = "Лучник орк"; archer[1] = "3"; archer[2]=" выстрелил из лука ";
            archer[3]="2"; archer[4]=" ударил клинком ";
            break; }
            case "undead" : { archer[0] = "Охотник"; archer[1] = "4"; archer[2]=" выстрелил из проклятого лука ";
            archer[3]="2";archer[4]=" атаковал когтями ";
            break; }
            case "human" : { archer[0] = "Арбалетчик"; archer[1] = "5"; archer[2]=" выстрелил из арбалета ";
            archer[3]="3"; archer[4]=" атаковал кортиком ";
            break; }
            case "elf" : { archer[0] = "Лучник эльф"; archer[1] = "7"; archer[2]=" выстрелил из точного лука ";
            archer[3]="3"; archer[4]=" ударил с разворота ";
            break; }
        }

        return archer;
    }
    @Override
    protected int getQuota() {
        return ARCHER_QUOTA;
    }
}
