package com.walking.intensive.chapter2.task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        int m = 128;
        int n = 80;

        System.out.println("\nНаибольший общий делитель чисел " + m + " и " + n + ": " + getGcd(m, n));
        System.out.println("\nНаибольший общий делитель чисел  " + m + " и " + n + " по алгоритму Евклида: " + getGcdByEuclideanAlgorithm(m, n));
        System.out.println("\nНаименьшее общее кратное чисел " + m + " и " + n + ": " + getLcm(m, n));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }

        return m * n / getGcd(m, n);
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }

        if (m == n) {
            return m;
        }

        List<Integer> multipliersM = getMultipliersOfNumber(m);
        List<Integer> multipliersN = getMultipliersOfNumber(n);
        multipliersM.retainAll(multipliersN);

        return Collections.max(multipliersM);
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью алгоритма Евклида
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }

        while (m != n) {
            if (m > n) {
                m -= n;
            } else {
                n -= m;
            }
        }

        return m;
    }

    private static List<Integer> getMultipliersOfNumber(int number) {
        List<Integer> listOfMultipliers = new ArrayList<>();

        int multiplier = 1;

        while (multiplier <= number) {
            if (number % multiplier == 0 && !listOfMultipliers.contains(multiplier))  {
                listOfMultipliers.add(multiplier);
            } else {
                multiplier++;
            }
        }

        return listOfMultipliers;
    }
}
