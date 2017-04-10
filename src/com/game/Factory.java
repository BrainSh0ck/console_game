package com.game;

/**
 * Created by root on 10.04.2017.
 */
abstract class Factory {
    public abstract Battle createMage();
    public abstract Battle createArcher();
    public abstract Battle createWarrior();
}
