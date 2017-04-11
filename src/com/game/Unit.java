package com.game;

/**
 * Created by root on 10.04.2017.
 */
public class Unit extends Constract implements Actions{
    Unit(final String race, Specs spec) {
        this.race = race;
        this.spec = spec;
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
        System.out.println(String.format("HP(%d)-%s ",getHP(),getName()));
        }


    @Override
    public Unit attack_mag(Unit unit) {
        return null;
    }

    @Override
    public Unit attack_war(Unit unit) {
       unit.hit(unit.getHP() - this.getmDmg());
       this.displayWar(getAction1(),unit);
        return unit;
    }

    @Override
    public Unit attack_arm(Unit unit) {
        return null;
    }

    @Override
    public Unit attack_arr(Unit unit) {
        return null;
    }

    @Override
    public Unit extra(Unit unit) {
        return null;
    }

    @Override
    public Unit dextra(Unit unit) {
        return null;
    }

    @Override
    public Unit curce(Unit unit) {
        return null;
    }

    public void displayWar(String console, Unit unit) {
        System.out.println(this.getName() + console + "по " + unit.getName() +" вышибив " + this.getmDmg() + " HP "
                +  " (" + unit.getHP()+" осталось)");
    }



}