package com.game;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 10.04.2017.
 */
public class Unit extends Constract implements Actions{
    private List<Unit> candidats = new LinkedList<Unit>();

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
    public void deExtra(boolean extra) {
        unit_init();
        this.extra = extra;
    }
    public void deCursed(boolean curce) {
        unit_init();
        this.cursed = curce;
    }
    private void setMag(String race) {
        String[] sets = new String[6];
        sets=this.spec.setMag(this.race);
        this.setName(sets[0]);
        this.setmDmg(Integer.parseInt(sets[3]));
        this.setAction1(sets[4]);
        this.setAction2(sets[5]);
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
    public void showSquadStat() {
        System.out.println(String.format("HP(%d)-%s extra: %s, cursed: %s, mDmg: %d rDmg: %d, hasMoved: %s"
                ,getHP(),getName(),isExtra(),isCursed(),getmDmg(),getrDmg(),hasMove));
    }

    public Unit do_action (Unit unit) {
       switch (getEntity_spec()) {
            case "mag" :  {

                if (( getEntity_race().equals("human") ) || ( getEntity_race().equals("elf") )) {
                    switch (Runner.random(2, 1)) {
                        case 1: {
                            attack_mag(unit);
                            break;
                        }
                        case 2: {
                            extra(unit);
                            break;
                        }
                    }
                }
                if (getEntity_race().equals("ork")) {
                    switch (Runner.random(2, 1)) {
                        case 1: {
                            dextra(unit);
                            break;
                        }
                        case 2: {
                            extra(unit);
                            break;
                        }
                    }
                }
                if (getEntity_race().equals("undead")) {
                    switch (Runner.random(2, 1)) {
                        case 1: {
                            attack_mag(unit);
                            break;
                        }
                        case 2: {
                            curce(unit);
                            break;
                        }
                    }
                }
             break;}
            case "archer" : {
                switch (Runner.random(2, 1)) {
                    case 1: {
                        attack_war(unit);
                        break;
                    }
                    case 2: {
                        attack_arr(unit);
                        break;
                    }
                }
                break;}
            case "warrior" : {
                    attack_war(unit);
                break;}
            default  : {break;}
        }


        return unit;
    }



    @Override
    public Unit attack_war(Unit unit) {
       unit.hit(unit.getHP() - this.getmDmg());
       this.displayWar(getAction1(),unit);
        return unit;
    }
    @Override
    public Unit attack_arr(Unit unit) {
        unit.hit(unit.getHP() - this.getmDmg());
        this.displayWar(getAction2(),unit);
        return unit;
    }
    @Override
    public Unit attack_mag(Unit unit) {
        unit.hit(unit.getHP() - this.getmDmg());
        this.displayWar(getAction1(),unit);
        return unit;
    }

    @Override
    public Unit extra(Unit unit) {
        if (Runner.light_full.contains(unit)) {
               for (Unit cont : Runner.dark_full) {
                    if (cont.getEntity_spec().equals(unit.getEntity_spec())) {
                        candidats.add(cont);
                    }
                }
        }
        if (Runner.dark_full.contains(unit)) {
            for (Unit cont : Runner.light_full) {
                if (cont.getEntity_spec().equals(unit.getEntity_spec())) {
                    candidats.add(cont);
                }
            }
        }
        Unit ob;
        int rnd_allow = 1;
        if (candidats.size() > 1) {
            int random = Runner.random(candidats.size() - 1, 1);
            if (random >= 1) {
                rnd_allow = random;
            }
            if (random == 0) {
                rnd_allow = 1;
            }
        }
        switch (rnd_allow) {
            case 1 : {
                candidats.get(0).setExtra(true);
                ob = candidats.get(0);
                break;
            }
            case 2 : {
                candidats.get(1).setExtra(true);
                ob = candidats.get(1);
                break;
            }
            case 3 : {
                candidats.get(2).setExtra(true);
                ob = candidats.get(2);
                break;
            }
            case 4 : {
                candidats.get(3).setExtra(true);
                ob = candidats.get(3);
                break;
            }
            default : {
                candidats.get(0).setExtra(true);
                ob = candidats.get(0);
                break;
            }

        }
        //unit.setExtra(true);
        this.displayExtra(getAction2(),ob);
        return ob;
    }

    @Override
    public Unit dextra(Unit unit) {
        if (Runner.light_full.contains(unit)) {
            for (Unit cont : Runner.light_full) {
                if (cont.isExtra()) {
                    cont.clearExtra(false); break;
                }
            }
        }
        if (Runner.dark_full.contains(unit)) {
            for (Unit cont : Runner.dark_full) {
                if (isExtra()) {
                    cont.clearExtra(false);break;
                }
            }
        }
        //unit.setExtra(true);
        this.displayDextra(getAction1(),unit);
        return unit;
    }

    @Override
    public Unit curce(Unit unit) {
        unit.setCursed(true);
        this.displayCurce(getAction2(),unit);
        return unit;
    }

    public void displayWar(String console, Unit unit) {
        System.out.println(this.getName() + console + "по " + unit.getName() +" вышибив " + this.getmDmg() + " HP "
                +  " (" + unit.getHP()+" осталось)");
    }
    public void displayExtra(String console, Unit unit) {
        System.out.println(this.getName() + console + "на " + unit.getName() +" увеличив его урон на 50%");
    }
    public void displayDextra(String console, Unit unit) {
        System.out.println(this.getName() + console + "на " + unit.getName() +" убрав с него улучшение");
    }
    public void displayCurce(String console, Unit unit) {
        System.out.println(this.getName() + console + "на " + unit.getName() +" уменьшив его урон на 50%");
    }
}