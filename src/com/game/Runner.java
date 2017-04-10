package com.game;

public class Runner {

    public static void main(String[] args) {
	Creator director = new Creator();
	Battle a = director.createWarrior();
	Battle b = director.createWarrior();
    a.race.make();
    a.face.attack_war(b);
    System.out.println(a.getHP());
    b.setDmg(10);
    System.out.println(b.getHP());


        //  System.out.println(a.face.toString());
    //  System.out.println(a.face.getClass());
       // ((War) a.face).attack_war(b);
    }
}
