package com.walking.intensive.chapter2.task7;

/**
 * Пятиклассник Ваня придумал забаву. Он ввел понятие «дружественной пары» чисел.
 * Два различных натуральных числа N и M он назвал дружественными, если сумма делителей числа N
 * (включая 1, но исключая само N) равна числу M и наоборот.
 *
 * <p>Например, 220 и 284 – дружественные числа:
 *
 * <ul>
 * <li>Список делителей для 220: 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110. Их сумма равна 284;
 * <li>Список делителей для 284: 1, 2, 4, 71, 142. Их сумма равна 220.
 * </ul>
 *
 * <p>Реализуйте метод getFriendlyPair(), который принимает параметром число N,
 * где N - натуральное число не больше 1 000 000.
 *
 * <p>Метод должен вернуть наибольшее число из пары дружественных чисел,
 * сумма дружественных чисел которой максимальна среди всех пар дружественных
 * чисел, большее из которых меньше N.
 *
 * <p> Если входные данные некорректны - метод должен возвращать -1.
 *
 * <p>P.S. Решение не должно использовать массивы и прочие темы, которые пока не были затронуты в курсе.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task7 {
    public static void main(String[] args) {
        System.out.print(getFriendlyPair(497));
    }

    static int getFriendlyPair(int n) {
        if (n < 1 || n > 1_000_000) {
            return -1;
        }

        int friendlyNumber1 = 0;
        int friendlyNumber2 = 0;

        for (int i = 1; i <= n; i++) {
            int bufferFriendlyNumber1 = getSumOfDivider(i, 1);
            int bufferFriendlyNumber2 = getSumOfDivider(bufferFriendlyNumber1, 1);

            if (isFriendlyPair(i, bufferFriendlyNumber1, bufferFriendlyNumber2)
                    && (i + bufferFriendlyNumber1) > (friendlyNumber1 + friendlyNumber2)) {
                friendlyNumber1 = i;
                friendlyNumber2 = bufferFriendlyNumber1;
            }
        }

        return Math.max(friendlyNumber1, friendlyNumber2);
    }

    private static int getSumOfDivider(int n, int divider) {
        if (divider == n || n == 0) {
            return 0;
        }

        if (n % divider == 0) {
            return divider + getSumOfDivider(n, divider + 1);
        }

        return getSumOfDivider(n, divider + 1);
    }

    private static boolean isFriendlyPair(int currentNumber, int number1, int number2) {
        return currentNumber == number2 && currentNumber != number1;
    }
}
