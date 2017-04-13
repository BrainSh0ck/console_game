package com.game;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 10.04.2017.
 */
public class Unit extends Constract implements Actions{
    private List<Unit> candidats = new LinkedList<Unit>();

    Unit(final String race, final Specs spec) {
        this.race = race;
        this.spec = spec;
        unit_init();
    }

    private void unit_init() {
        setEntity_race(this.race);
        setEntity_spec(spec_init());
        switch (getEntity_spec()) {
            case Constants.MAG : {setMag(this.race);break;}
            case Constants.ARCHER : {setArcher(this.race);break;}
            case Constants.WARRIOR : {setWarrior(this.race);break;}
            default : {break;}
        }
    }

    private String spec_init() {
        String spec;
        switch (this.spec.toString()) {
            case "1": {
                spec = Constants.MAG ;
                break;
            }
            case "2": {
                spec = Constants.ARCHER;
                break;
            }
            case "3": {
                spec = Constants.WARRIOR;
                break;
            }
            default: {
                spec = "";
                break;
            }
        }
        return spec;
    }
    public void deExtra(final boolean extra) {
        setmDmg(getOld_mDmg());
        setrDmg(getOld_rDmg());
        this.extra = extra;
    }
    public void deCursed(final boolean curce) {
        setmDmg(getOld_mDmg());
        setrDmg(getOld_rDmg());
        this.cursed = curce;
    }
    private void setMag(final String race) {
        String[] sets = new String[6];
        sets=this.spec.setMag(this.race);
        this.setName(sets[0]);
        this.setmDmg(Integer.parseInt(sets[3]));
        this.setAction1(sets[4]);
        this.setAction2(sets[5]);
    }
    private void setArcher(final String race) {
        String[] sets = new String[5];
        sets=this.spec.setArcher(this.race);
        this.setName(sets[0]);
        this.setmDmg(Integer.parseInt(sets[1]));
        this.setAction1(sets[2]);
        this.setrDmg(Integer.parseInt(sets[3]));
        this.setAction2(sets[4]);
    }
    private void setWarrior(final String race) {
        String[] sets = new String[4];
        sets=this.spec.setWarrior(this.race);
        this.setName(sets[0]);
        this.setmDmg(Integer.parseInt(sets[1]));
        this.setAction1(sets[2]);
    }
    public void showSquadStat() {
        System.out.println(String.format("HP(%d)-%s extra: %s, cursed: %s, mDmg: %d rDmg: %d, hasMoved: %s"
                ,getHP(),getName(),isExtra(),isCursed(),getmDmg(),getrDmg(),hasMove));
    }

    public Unit do_action (Unit unit) {
       if (unit.getHP() < 0 ) {

       }
        switch (getEntity_spec()) {
            case Constants.MAG :  {

                if (( getEntity_race().equals(Constants.HUMAN) ) || ( getEntity_race().equals(Constants.ELF) )) {
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
                if (getEntity_race().equals(Constants.ORK)) {
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
                if (getEntity_race().equals(Constants.UNDEAD)) {
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
            case Constants.ARCHER : {
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
            case Constants.WARRIOR : {
                    attack_war(unit);
                break;}
            default  : {break;}
        }


        return unit;
    }



    @Override
    public Unit attack_war(final Unit unit) {
       unit.hit(unit.getHP() - this.getmDmg());
       this.displayWar(getAction1(),unit);
        return unit;
    }
    @Override
    public Unit attack_arr(final Unit unit) {
        unit.hit(unit.getHP() - this.getmDmg());
        this.displayWar(getAction2(),unit);
        return unit;
    }
    @Override
    public Unit attack_mag(final Unit unit) {
        unit.hit(unit.getHP() - this.getmDmg());
        this.displayWar(getAction1(),unit);
        return unit;
    }

    @Override
    public Unit extra(final Unit unit) {
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
                candidats.get(0).setNext_extra(true);
                ob = candidats.get(0);
                break;
            }
            case 2 : {
                candidats.get(1).setNext_extra(true); //setExtra true
                ob = candidats.get(1);
                break;
            }
            case 3 : {
                candidats.get(2).setNext_extra(true);
                ob = candidats.get(2);
                break;
            }
            case 4 : {
                candidats.get(3).setNext_extra(true);
                ob = candidats.get(3);
                break;
            }
            default : {
                candidats.get(0).setNext_extra(true);
                ob = candidats.get(0);
                break;
            }

        }
        this.displayExtra(getAction2(),ob);
        return ob;
    }

    @Override
    public Unit dextra(final Unit unit) {
        Unit ob = new Unit(Constants.ORK,new Warrior());
        int random;
        if (Runner.light_full.contains(unit)) {

            for (Unit cont : Runner.light_full) {
                if (cont.isExtra()) {
                    cont.setNext_clear(true);
                    ob = cont;

                }
                if (Runner.light_full.size() > 1) {
                    random = Runner.random(Runner.light_full.size() - 1, 0);
                } else {
                    random = 0;
                  }
                    try {
                    ob = Runner.light_full.get(random);
                    ob.setNext_clear(true);
                    } catch (Exception e) {

                    }

            }
        } else {
            for (Unit cont : Runner.dark_full) {
                if (isExtra()) {
                    cont.setNext_clear(true); //clear Extra (false)
                    ob = cont;

                }
                if (Runner.dark_full.size() > 1) {
                    random = Runner.random(Runner.dark_full.size() - 1, 0);
                } else {
                    random = 0;
                  }

                    try {
                       ob = Runner.dark_full.get(random);
                       ob.setNext_clear(true);
                    } catch (Exception e) {

                    }

            }
        }


        this.displayDextra(getAction1(),ob);
        return ob;
    }

    @Override
    public Unit curce(final Unit unit) {
        unit.setNext_cursed(true); //setCursed true
        this.displayCurce(getAction2(),unit);
        return unit;
    }

    public void displayWar(final String console, final Unit unit) {
        System.out.println(this.getName() + console + "по " + unit.getName() +" вышибив " + this.getmDmg() + " HP "
                +  " (" + unit.getHP()+" осталось)");
    }
    public void displayExtra(final String console, final Unit unit) {
        System.out.println(this.getName() + console + "на " + unit.getName() +" увеличив его урон на 50%");
    }
    public void displayDextra(final String console,final Unit unit) {
        System.out.println(this.getName() + console + "на " + unit.getName() +" запретив ему улучшения");
    }
    public void displayCurce(final String console,final Unit unit) {
        System.out.println(this.getName() + console + "на " + unit.getName() +" уменьшив его урон на 50%");
    }
    protected void consoleDead () {
        System.out.println("Персонаж " + getName() + " умер.");
    }
}