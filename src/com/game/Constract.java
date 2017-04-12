package com.game;

/**
 * Created by root on 10.04.2017.
 * Главный предок объекта со всеми общими свойствами
 */
public abstract class Constract {
    protected String race;
    protected Specs spec;

    private static final int MAX_HP = 100;
    private int HP = (int)MAX_HP;

    private String entity_race;
    private String entity_spec;

    private String name;
    private int mDmg = -1;
    private int rDmg = -1;
    private String action1 = "";
    private String action2 = "";

    Constract(){
    }

    protected boolean hasMove = false;
    protected boolean extra = false;
    protected boolean cursed = false;

    public boolean isExtra() {
        return extra;
    }

    public void clearExtra(boolean extra) {
        this.extra = extra;
    }
    public void setExtra(boolean extra) {
        float upM = mDmg*1.5F;
        this.mDmg = (int)upM;
        float upR = rDmg*1.5F;
        this.rDmg = (int)upR;
        this.extra = extra;
    }
    public boolean isCursed() {
        return cursed;
    }

    public void setCursed(boolean cursed) {
        float upM = mDmg/1.5F;
        this.mDmg = (int)upM;
        float upR = rDmg/1.5F;
        this.rDmg = (int)upR;

        this.cursed = cursed;
    }

    public String getName() {
        return name;
    }

    public String getEntity_race() {
        return entity_race;
    }

    public void setEntity_race(String entity_race) {
        this.entity_race = entity_race;
    }

    public String getEntity_spec() {
        return entity_spec;
    }

    public void setEntity_spec(String entity_spec) {
        this.entity_spec = entity_spec;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getmDmg() {
        return mDmg;
    }

    public void setmDmg(int mDmg) {
        this.mDmg = mDmg;
    }

    public int getrDmg() {
        return rDmg;
    }

    public void setrDmg(int rDmg) {
        this.rDmg = rDmg;
    }

    public String getAction1() {
        return action1;
    }

    public String getAction2() {
        return action2;
    }

    public void setAction1(String action1) {
        this.action1 = action1;
    }

    public void setAction2(String action2) {
        this.action2 = action2;
    }

    public int getHP() {
        return HP;
    }

    public void hit(int HP) {
        this.HP = HP;
    }



}