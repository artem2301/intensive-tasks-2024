package com.walking.intensive.chapter2.task10;

import java.util.Locale;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум."));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.isEmpty() || inputString.length() == 1) {
            return false;
        }

        String formattedString = formatString(inputString);

        for (int i = 0; i < formattedString.length() / 2; i++) {
            if (!(formattedString.charAt(i) == formattedString.charAt(formattedString.length() - i - 1))) {
                return false;
            }
        }

        return true;
    }

    private static String formatString(String str) {
        str = str.replaceAll("\\pP", "");
        str = str.replaceAll("\\s", "");

        return str.toLowerCase(Locale.ROOT);
    }
}
