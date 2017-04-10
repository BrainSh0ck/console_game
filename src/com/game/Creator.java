package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Creator extends Factory {

    @Override
    public Battle createMage() {
        return null;
    }

    @Override
    public Battle createArcher() {

        return null;
    }

    @Override
    public Battle createWarrior() {
        return new Battle(new Ork(), new War(), new Warrior());
    }
}
