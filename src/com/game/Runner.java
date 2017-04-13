package com.game;

import java.util.*;

/**
 *  Класс в котором находиться точка входа в программу
 */
public class Runner {

    /**
     * Набор коллекций для работы с отрядами объектов
     */
    public static List<Unit> light_full = new LinkedList<Unit>();
    public static List<Unit> dark_full = new LinkedList<Unit>();
    public static List<Unit> light = new LinkedList<Unit>();
    public static List<Unit> dark = new LinkedList<Unit>();
    public static List<Unit> light_extra = new LinkedList<Unit>();
    public static List<Unit> dark_extra = new LinkedList<Unit>();


    public static void welcome() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        welcome();
        //scanner.nextLine();
        Director director = new Director();
        director.MakeSquads();
        while ( (dark_full.size() > 0) && (light_full.size() > 0)) {
            roundCircle();
        }
    }

    /**
     *  Методы атаки привелигированных войск
     */
    public static void roundCircle () {
        roundStart();
        doRound();
        roundEnd();

    }
    public static void light_extraAttack (){
        if ((light_extra.size()-1) == 0) {
            light_extra.get(0).do_action(dark_full.get(random(dark_full.size() - 1, 0)));
            light_extra.get(0).hasMove = true;
            light_extra.remove(0);
            if (dark_extra.size() > 0) {
                dark_extraAttack();
            } else {darkAttack();}
        }
    }
    public static void dark_extraAttack () {
        if ((dark_extra.size()-1) == 0) {
            dark_extra.get(0).do_action(light_full.get(random(light_full.size() - 1, 0)));
            dark_extra.get(0).hasMove = true;
            dark_extra.remove(0);
            if (light_extra.size() > 0) {
                light_extraAttack();
            } else {lightAttack();}
        }
    }

    /**
     * Методы атаки обычных войск
     */
    public static void lightAttack() {
        if ((light.size()-1) > 0) {
            int random = random(light.size() - 1, 0);
            light.get(random).do_action(dark_full.get(random(dark_full.size() - 1, 0)));
            light.get(random).hasMove = true;
            light.remove(random);
            darkAttack();
         //   System.out.println(light.size());
        }
        if ((light.size()-1) == 0) {
            light.get(0).do_action(dark_full.get(random(dark_full.size() - 1, 0)));
            light.get(0).hasMove = true;
            light.remove(0);
           // System.out.println("last");
        }
    }
    public static void darkAttack() {
        if ((dark.size()-1) > 0) {
            int random = random(dark.size() - 1, 0);
            dark.get(random).do_action(light_full.get(random(light_full.size() - 1, 0)));
            dark.get(random).hasMove = true;
            dark.remove(random);
            lightAttack();
            //System.out.println(dark.size());
        }
        if ((dark.size()-1) == 0) {
            dark.get(0).do_action(light_full.get(random(light_full.size() - 1, 0)));
            dark.get(0).hasMove = true;
            dark.remove(0);
            //System.out.println("last");
        }
    }

    /**
     * Функция рандомизатор взята из офф. исходников
     * @param max максимальное случайное значени
     * @param min минимальное случайное значение
     * @return целое случайное число
     */
    public static int random(final int max, final int min) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * Работа с коллекциями объектов на старте раунда
     */
    public static void roundStart() {
        light.clear();
        dark.clear();
        light_extra.clear();
        dark_extra.clear();
        for (Unit c : light_full) {
            if(c.isNext_extra()) { c.setExtra(true); c.setNext_extra(false); }
            if(c.isNext_clear()) { c.clearExtra(false); c.setNext_clear(false);}
            if(c.isNext_cursed()) { c.setCursed(true); c.setNext_cursed(false);}
            if (c.isExtra()) {
                light_extra.add(c);
            } else {light.add(c);}
        }
        for (Unit c : dark_full) {
            if(c.isNext_extra()) { c.setExtra(true); c.setNext_extra(false); }
            if(c.isNext_clear()) { c.clearExtra(false); c.setNext_clear(false);}
            if(c.isNext_cursed()) { c.setCursed(true); c.setNext_cursed(false);}
            if (c.isExtra()) {
                dark_extra.add(c);
            } else {dark.add(c);}
        }
    }

    /**
     * Собственно сама реализация раунда
     */
    public static void doRound() {

            switch (random(2,1)) {
                case 1 : {
                    while ((light.size() > 0) | (dark.size() > 0)) {
                    if (light_extra.size() >= 0) light_extraAttack();
                        lightAttack();
                        darkAttack();
                    }
                break;
                }

                case 2 : {
                    while ((dark.size() > 0) | (light.size() > 0)) {
                    if(dark_extra.size() >= 0) dark_extraAttack();
                        darkAttack();
                        lightAttack();

                    }
                break;
                }
            }

        System.out.print("-----------------------------------------------------------------");System.out.println();
     //здесь будут умирать
        spitOfDeath();
    }


    /**
     * Работа с объектами по окончанию раунда
     */

    public static void roundEnd() {
        for (Unit e : light_full) {
            if (e.isExtra()) {
                e.deExtra(false);
            } if (e.isCursed()) {
                e.deCursed(false);
            }
            e.hasMove = false;
        }
        for (Unit e : dark_full) {
            if (e.isExtra()) {
                e.deExtra(false);
            } if (e.isCursed()) {
                e.deCursed(false);
            }
            e.hasMove = false;
        }
    }
    public static void spitOfDeath() {
        for (int u = 0; u <= light_full.size()-1; u++ ) {
            if (light_full.get(u).getHP() <= 0 ) {
                light_full.get(u).consoleDead();
                light_full.remove(u);
            }
        }
        for (int u = 0; u <= dark_full.size()-1; u++) {
            if (dark_full.get(u).getHP() <= 0 ) {
                dark_full.get(u).consoleDead();
                dark_full.remove(u);
            }
        }
    }
    /**
     * Метод отладки
     * @param list коллекция объектов
     */
    public static void showCollection (List<Unit> list) {
        for (Unit l : list) {
            //l.showEntity();
            l.showSquadStat();
        }
        System.out.println("***************************************************************");
    }
    public static void clear_static () {
        light_full.clear();
        light.clear();
        light_extra.clear();

        dark_full.clear();
        dark.clear();
        dark_extra.clear();
    }
}
