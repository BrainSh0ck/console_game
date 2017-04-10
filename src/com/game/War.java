package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class War extends Arts  {

    @Override
    public Battle attack_war(Battle un) {
        un.setDmg(50);
        return un;
    }

}
