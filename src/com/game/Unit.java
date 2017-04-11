package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Unit extends Construct {
    Unit(final String race, Specs spec,Actions action) {
        this.race = race;
        this.spec = spec;
        this.action = action;
        unit_init();
    }

    private void unit_init() {
        setEntity_race(this.race);
        setEntity_spec(spec_init());
        switch (getEntity_spec()) {
            case "mag" : {setMag(this.race);break;}
            case "archer" : {setArcher(this.race);break;}
            case "warrior" : {setWarrior(this.race);break;}
            default : {break;}
        }
    }

    private String spec_init() {
        String spec;
        switch (this.spec.toString()) {
            case "1": {
                spec = "mag";
                break;
            }
            case "2": {
                spec = "archer";
                break;
            }
            case "3": {
                spec = "warrior";
                break;
            }
            default: {
                spec = "";
                break;
            }
        }
        return spec;
    }

    private void setMag(String race) {
        String[] sets = new String[4];
        sets=this.spec.setMag(this.race);
        this.setName(sets[0]);
        this.setmDmg(Integer.parseInt(sets[1]));
        this.setAction1(sets[2]);
        this.setAction2(sets[3]);
        this.setQuota(this.spec.getQuota());
    }
    private void setArcher(String race) {
        String[] sets = new String[5];
        sets=this.spec.setArcher(this.race);
        this.setName(sets[0]);
        this.setmDmg(Integer.parseInt(sets[1]));
        this.setAction1(sets[2]);
        this.setrDmg(Integer.parseInt(sets[3]));
        this.setAction2(sets[4]);
        this.setQuota(this.spec.getQuota());
    }
    private void setWarrior(String race) {
        String[] sets = new String[4];
        sets=this.spec.setWarrior(this.race);
        this.setName(sets[0]);
        this.setmDmg(Integer.parseInt(sets[1]));
        this.setAction1(sets[2]);
        this.setQuota(this.spec.getQuota());
    }
    public void showEntity() {
        System.out.println(String.format("%s-%s # %s: %d %s %d %s %s (%d)",getEntity_race(),getEntity_spec(),getName(), getmDmg(),
                getAction1(), getrDmg(),getAction2(),getAction3(),getQuota()));
        }





}