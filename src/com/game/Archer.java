package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Archer extends Specs {

    @Override
    public String toString() {
        return String.format("%s","2");
    }

    @Override
    protected String[] setArcher (final String race) {
        String[] archer = new String[5];
        switch (race) {
            case Constants.ORK : { archer[0] = "Лучник орк"; archer[1] = "3"; archer[2]=" выстрелил из лука ";
            archer[3]="2"; archer[4]=" ударил клинком ";
            break; }
            case Constants.UNDEAD : { archer[0] = "Охотник"; archer[1] = "4"; archer[2]=" выстрелил из проклятого лука ";
            archer[3]="2";archer[4]=" атаковал когтями ";
            break; }
            case Constants.HUMAN : { archer[0] = "Арбалетчик"; archer[1] = "5"; archer[2]=" выстрелил из арбалета ";
            archer[3]="3"; archer[4]=" атаковал кортиком ";
            break; }
            case Constants.ELF : { archer[0] = "Лучник эльф"; archer[1] = "7"; archer[2]=" выстрелил из точного лука ";
            archer[3]="3"; archer[4]=" ударил с разворота ";
            break; }
        }

        return archer;
    }

}
