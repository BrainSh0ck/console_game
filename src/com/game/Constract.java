package com.game;
/**
 * Created by root on 10.04.2017.
 * Главный предок объекта со всеми общими свойствами
 */
public abstract class Constract {
    protected String race;
    protected Specs spec;

    private int HP = (int)Constants.MAX_HP;

    private String entity_race;
    private String entity_spec;

    private String name;
    private int mDmg = -1;
    private int rDmg = -1;
    private int old_mDmg = -1;
    private int old_rDmg = -1;
    private String action1 = "";
    private String action2 = "";

    Constract(){
    }

    protected boolean hasMove = false;
    protected boolean extra = false;
    protected boolean cursed = false;

    protected boolean next_extra = false;
    protected boolean next_cursed = false;


    protected boolean next_clear = false;


    public boolean isExtra() {
        return extra;
    }

    public void clearExtra(final boolean extra) {
        setmDmg(getOld_mDmg());
        setrDmg(getOld_rDmg());
        this.extra = extra;
    }
    public void setExtra(final boolean extra) {
        if (!isCursed()) {
        this.old_mDmg = this.mDmg;
        this.old_rDmg = this.rDmg;
        }
        float upM = mDmg*1.5F;
        this.mDmg = (int)upM;
        float upR = rDmg*1.5F;
        this.rDmg = (int)upR;
        this.extra = extra;
    }
    public boolean isCursed() {
        return cursed;
    }

    public void setCursed(final boolean cursed) {
        if (!isExtra()) {
        this.old_mDmg = this.mDmg;
        this.old_rDmg = this.rDmg;
        }
        float upM = mDmg/1.5F;
        this.mDmg = (int)upM;
        float upR = rDmg/1.5F;
        this.rDmg = (int)upR;

        this.cursed = cursed;
    }

    public boolean isNext_clear() {
        return next_clear;
    }

    public void setNext_clear(boolean next_clear) {
        this.next_clear = next_clear;
    }

    public boolean isNext_extra() {
        return next_extra;
    }

    public void setNext_extra(boolean next_extra) {
        this.next_extra = next_extra;
    }

    public boolean isNext_cursed() {
        return next_cursed;
    }

    public void setNext_cursed(boolean next_cursed) {
        this.next_cursed = next_cursed;
    }

    public int getOld_mDmg() {
        return old_mDmg;
    }

    public int getOld_rDmg() {
        return old_rDmg;
    }

    public String getName() {
        String new_name;
        if (isExtra()) {
            new_name = "Улучшенный " + this.name;
        } else new_name=name;
        return new_name;
    }

    public String getEntity_race() {
        return entity_race;
    }

    public void setEntity_race(final String entity_race) {
        this.entity_race = entity_race;
    }

    public String getEntity_spec() {
        return entity_spec;
    }

    public void setEntity_spec(final String entity_spec) {
        this.entity_spec = entity_spec;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getmDmg() {
        return mDmg;
    }

    public void setmDmg(final int mDmg) {
        this.mDmg = mDmg;
    }

    public int getrDmg() {
        return rDmg;
    }

    public void setrDmg(final int rDmg) {
        this.rDmg = rDmg;
    }

    public String getAction1() {
        return action1;
    }

    public String getAction2() {
        return action2;
    }

    public void setAction1(final String action1) {
        this.action1 = action1;
    }

    public void setAction2(final String action2) {
        this.action2 = action2;
    }

    public int getHP() {
        return HP;
    }

    public void hit(final int HP) {
        this.HP = HP;
    }



}