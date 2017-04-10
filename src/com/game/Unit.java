package com.game;

/**
 * Created by root on 10.04.2017.
 */
public abstract class Unit {
    protected Arts face;
    protected Specs spec;
    protected Races race;


    private static final int MAX_HP = 100;
    private int HP = (int)MAX_HP;

    private int quota;

    private boolean normal = true;
    private boolean extra = false;
    private boolean cursed = false;

    private String name;
    private int dmg;
    private String action1;
    private String action2;
    private String action3;

    Unit(){

    }



    //----------------------------------------------------------------------------------------//
    public int getHP() {
        return HP;
    }

    public void hit(int HP) {
        this.HP = HP;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public boolean status() {
        return normal;
    }

    public void setNormal(boolean normal) {
        this.normal = normal;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public void setCursed(boolean cursed) {
        this.cursed = cursed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.HP = this.HP - dmg;
    }

}