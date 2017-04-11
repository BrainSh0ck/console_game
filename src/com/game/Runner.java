package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {

    public static List<Unit> light = new ArrayList<Unit>();
    public static List<Unit> dark = new ArrayList<Unit>();
    //static public List<List> squad = new ArrayList<List>();

    public static void main(String[] args) {
        Director director = new Director();
        //Runner battle = new Runner();
        director.MakeSquads();
        for (Unit l : light) {
            l.showEntity();
        }
        for (Unit d : dark) {
            d.showEntity();
        }

        // / light = squad[0];
        //Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        //for (int i = 0; i < 20 ; i++) {
          //  int randomNum = rand.nextInt((4 - 1) + 1) + 1;
           // System.out.println(randomNum);
        //}
        //Director director = new Director();
	    //director.MakeSquads();
        //Unit a = director.createMage();
	//Unit b = director.createArcher();
	//Unit c = director.createWarrior();
    //	a.showEntity();
    //	b.showEntity();
    //	c.showEntity();
    }
}
