package com.walking.intensive.chapter2.task6;

import java.util.Arrays;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        int m = 1236;
        int n = 998;

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

        int[] multipliersM = getMultipliersOfNumber(m);
        int[] multipliersN = getMultipliersOfNumber(n);

        int[] shareMultipliers = new int[0];

        for (int i = 0; i < multipliersM.length; i++) {
            int shareElementIndex = Arrays.binarySearch(multipliersN, multipliersM[i]);

            if (shareElementIndex >= 0) {
                shareMultipliers = addElementInArray(shareMultipliers, multipliersN[shareElementIndex]);
            }
        }

        return shareMultipliers[shareMultipliers.length - 1];
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

        if (m == n) {
            return m;
        }

        if (m > n) {
            return getGcdByEuclideanAlgorithm(m - n, n);
        }

        return getGcdByEuclideanAlgorithm(m, n - m);
    }

    private static int[] getMultipliersOfNumber(int number) {
        int[] arrayOfMultipliers = new int[0];

        int multiplier = 1;

        while (multiplier <= number) {
            if (number % multiplier == 0 && Arrays.binarySearch(arrayOfMultipliers, multiplier) < 0)  {
                arrayOfMultipliers = addElementInArray(arrayOfMultipliers, multiplier);
            }

            multiplier++;
        }

        return arrayOfMultipliers;
    }

    private static int[] addElementInArray(int[] array, int newElement) {
        int[] newArray = new int[array.length + 1];

        System.arraycopy(array, 0, newArray, 0, array.length);

        newArray[newArray.length - 1] = newElement;

        return newArray;
    }
}
