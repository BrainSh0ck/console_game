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


    public static void main(String[] args) {
        Director director = new Director();
        director.MakeSquads();
        roundStart();
        doRound();

        //roundStart();
        //doRound();
        showCollection(light_full);
        showCollection(dark_full);
        //roundEnd();

    }

    /**
     *  Методы атаки привелигированных войск
     */
    public static void light_extraAttack (){
        if (light_extra.size()-1 > 0) {
            int random = random(light.size() - 1, 0);
            light_extra.get(random).do_action(dark_full.get(random(dark_full.size() - 1, 0)));
            light_extra.get(random).hasMove = true;
            light_extra.remove(random);
            System.out.println(light_extra.size());
        }
        if (light_extra.size()-1 == 0) {
            light_extra.get(0).do_action(dark_full.get(random(dark_full.size() - 1, 0)));
            light_extra.get(0).hasMove = true;
            light_extra.remove(0);
        }
    }
    public static void dark_extraAttack () {
        if (dark_extra.size()-1 > 0) {
            int random = random(dark.size() - 1, 0);
            dark_extra.get(random).do_action(light_full.get(random(light_full.size() - 1, 0)));
            dark_extra.get(random).hasMove = true;
            dark_extra.remove(random);
            System.out.println(dark.size());
        }
        if (dark_extra.size()-1 == 0) {
            dark_extra.get(0).do_action(light_full.get(random(light_full.size() - 1, 0)));
            dark_extra.get(0).hasMove = true;
            dark_extra.remove(0);
        }
    }

    /**
     * Методы атаки обычных войск
     */
    public static void lightAttack() {
        if (light.size()-1 > 0) {
            int random = random(light.size() - 1, 0);
            light.get(random).do_action(dark_full.get(random(dark_full.size() - 1, 0)));
            light.get(random).hasMove = true;
            light.remove(random);
            //System.out.println(light.size());
        }
        if (light.size()-1 == 0) {
            light.get(0).do_action(dark_full.get(random(dark_full.size() - 1, 0)));
            light.get(0).hasMove = true;
            light.remove(0);
        }
    }
    public static void darkAttack() {
        if (dark.size()-1 > 0) {
            int random = random(dark.size() - 1, 0);
            dark.get(random).do_action(light_full.get(random(light_full.size() - 1, 0)));
            dark.get(random).hasMove = true;
            dark.remove(random);
         //   System.out.println(dark.size());
        }
        if (dark.size()-1 == 0) {
            dark.get(0).do_action(light_full.get(random(light_full.size() - 1, 0)));
            dark.get(0).hasMove = true;
            dark.remove(0);
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
        for (Unit c : light_full) {
            if (c.isExtra()) {
                light_extra.add(c);
            } else {light.add(c);}
        }
        for (Unit c : dark_full) {
            if (c.isExtra()) {
                dark_extra.add(c);
            } else {dark.add(c);}
        }
    }

    /**
     * Собственно сама реализация раунда
     */
    public static void doRound() {
        for (int i = 0; i <16 ; i++) {
            switch (random(2,1)) {
                case 1 : {
                    if(light_extra.size() >= 0)light_extraAttack();
                        if(light_extra.size() == 0) {
                            //System.out.println(light_extra.size());
                            if (light.size() >= 0) lightAttack();
                        }
                    break;}
                case 2 : {
                    if(dark_extra.size() >= 0)dark_extraAttack();
                    if (dark_extra.size() == 0) {
                        //System.out.println(dark_extra.size());
                        if (dark.size() >= 0) darkAttack();
                    }
                    break;}
            }
         }
        System.out.print("-----------------------------------------------------------------");System.out.println();
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
        }
        for (Unit e : dark_full) {
            if (e.isExtra()) {
                e.setExtra(false);
            } if (e.isCursed()) {
                e.setCursed(false);
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
}
