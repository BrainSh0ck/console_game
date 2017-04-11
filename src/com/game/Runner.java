package com.game;

import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

public class Runner {

    public static List<Unit> light = new ArrayList<Unit>();
    public static List<Unit> dark = new ArrayList<Unit>();

    public static void main(String[] args) {
        Director director = new Director();
        director.MakeSquads();
        for (Unit l : light) {
            l.showEntity();
        }
        for (Unit d : dark) {
            d.showEntity();
        }
     //dark.get(0).action
    }
}
