package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Director extends Former {
    private static final String ORK = "ork";
    private static final String UNDEAD = "undead";
    private static final String HUMAN = "human";
    private static final String ELF = "elf";
    @Override
    public Unit createMage() {

        return new Unit(UNDEAD, new Mag());
    }

    @Override
    public Unit createArcher() {

        return new Unit(ORK,new Archer());
    }

    @Override
    public Unit createWarrior() {
        return new Unit(HUMAN,  new Warrior());
    }
}
