package com.game;

public class Runner {

    public static void main(String[] args) {
	Director director = new Director();
	Unit a = director.createMage();
	Unit b = director.createArcher();
	Unit c = director.createWarrior();
    	a.showEntity();
    	b.showEntity();
    	c.showEntity();
    }
}
