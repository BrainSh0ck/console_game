package com.game;

import java.util.*;

public class Runner {

    public static List<Unit> light_ready = new LinkedList<Unit>();
    public static List<Unit> dark_ready = new LinkedList<Unit>();
    public static List<Unit> light = new LinkedList<Unit>();
    public static List<Unit> dark = new LinkedList<Unit>();


    public static void main(String[] args) {
        Director director = new Director();
        director.MakeSquads();
        light.addAll(light_ready);
        dark.addAll(dark_ready);
        for (int i = 0; i <20 ; i++) {
            switch (random(2,1)) {
                case 1 : {if(light.size() >= 0)lightAttack();break;}
                case 2 : {if(dark.size() >= 0)darkAttack();break;}
            }
        }
        for (Unit l : light) {
            l.showEntity();
        }
        for (Unit d : dark) {
            d.showEntity();
        }


    }

    public static void lightAttack() {
        if (light.size()-1 > 0) {
            int random = random(light.size() - 1, 0);
            light.get(random).attack_war(dark_ready.get(random(dark_ready.size() - 1, 0)));
            light.get(random).hasMove = true;
            light.remove(random);
            //System.out.println(light.size());
        }
        if (light.size()-1 == 0) {
            light.get(0).attack_war(dark_ready.get(random(dark_ready.size() - 1, 0)));
            light.get(0).hasMove = true;
            light.remove(0);
        }
    }
    public static void darkAttack() {
        if (dark.size()-1 > 0) {
            int random = random(dark.size() - 1, 0);
            dark.get(random).attack_war(light_ready.get(random(light_ready.size() - 1, 0)));
            dark.get(random).hasMove = true;
            dark.remove(random);
         //   System.out.println(dark.size());
        }
        if (dark.size()-1 == 0) {
            dark.get(0).attack_war(light_ready.get(random(light_ready.size() - 1, 0)));
            dark.get(0).hasMove = true;
            dark.remove(0);
        }
    }
    public static int random(final int max, final int min) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}
