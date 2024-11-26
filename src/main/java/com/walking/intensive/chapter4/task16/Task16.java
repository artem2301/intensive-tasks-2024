package com.walking.intensive.chapter4.task16;

import java.util.Arrays;

/**
 * После завершения интенсива вы достаточно быстро познакомитесь с Java Collection Framework.
 * Это знакомство позволит сильно упростить работу с массивами данных.
 *
 * <p>Но пока этого не произошло - даже типовые операции приходится производить вручную.
 * Эта задача - наглядная тому демонстрация.
 *
 * <p>Удачи!
 *
 * <p>P.S. Обратите внимание: если в методе требуется как-то изменять
 * содержимое массива - метод всегда должен возвращать новый массив.
 * Массивы, передаваемые в параметрах, изменяться не должны.
 * Это связано с тем, что в реальных условиях такой входящий массив может далее
 * использоваться в каких-либо иных расчетах и ожидается, что он будет находиться
 * в своем исходном состоянии.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task16 {
    public static void main(String[] args) {
        System.out.println("isEqualSize: " + isEqualSize(new int[]{}, new int[]{}));
        System.out.println("isEquals: " + isEquals(new int[]{1, 5, 6, 78}, new int[]{1, 5, 6, 78}));
        System.out.println("incrementEach: " + Arrays.toString(incrementEach(new int[]{1, 5, 6, 78})));
        System.out.println("multiplyEach: " + Arrays.toString(multiplyEach(new int[]{1, 5, 6, 78, 0, 0}, new int[]{1, 5, 6, 78})));
        System.out.println("subtractEach: " + Arrays.toString(subtractEach(new int[]{51, 5, 6, 77, 35, 55}, new int[]{3, 3, 16, 78})));
        System.out.println("subtractEach: " + Arrays.toString(subtractEach(new int[]{2, 4, 6}, new int[]{1, 2})));
        System.out.println("reverse: " + Arrays.toString(reverse(new int[]{1, 5, 6, 78})));
        System.out.println("add: " + Arrays.toString(add(new int[]{10, 11, 12}, 1, 300)));
        System.out.println("add: " + Arrays.toString(add(new int[]{1, 5, 6, 78}, -12, 123)));
        System.out.println("add: " + Arrays.toString(add(new int[]{1, 5, 6, 78}, 0, 123)));
        System.out.println("isContains: " + isContains(new int[]{1, 5, 6, 78}, 6));
        System.out.println("isContains: " + isContains(new int[]{1, 5, 6, 78}, 100));
        System.out.println("getFirstIndex: " + getFirstIndex(new int[]{1, 5, 6, 78}, 78));
        System.out.println("getFirstIndex: " + getFirstIndex(new int[]{1, 5, 6, 78}, 100));
        System.out.println("getLastIndex: " + getLastIndex(new int[]{1, 5, 1, 78, 1}, 1));
        System.out.println("getLastIndex: " + getLastIndex(new int[]{1, 5, 1, 78, 1}, 100));
        System.out.println("removeByIndex: " + Arrays.toString(removeByIndex(new int[]{1, 5, 6, 78}, 0)));
        System.out.println("removeByIndex: " + Arrays.toString(removeByIndex(new int[]{1, 5, 6, 78}, 3)));
        System.out.println("removeByIndex: " + Arrays.toString(removeByIndex(new int[]{1, 5, 6, 78}, -4)));
        System.out.println("removeByIndex: " + Arrays.toString(removeByIndex(new int[]{1, 5, 6, 78}, 10)));
        System.out.println("removeAll: " + Arrays.toString(removeAll(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{10, 1, 30, 2})));
        System.out.println("removeAll: " + Arrays.toString(removeAll(new int[]{1, 5, 6, 78}, new int[]{1, 5, 6, 78, 9})));
        System.out.println("removeAll: " + Arrays.toString(removeAll(new int[]{1, 2, 3, 4, 5, 6, 7}, 5)));
        System.out.println("removeAll: " + Arrays.toString(removeAll(new int[]{1, 5, 6, 78, 10}, new int[]{1, 5, 8, 6, 78})));
        System.out.println("isSimilar: " + isSimilar(new int[]{1, 5, 6, 78}, new int[]{1, 5, 6, 78}));
        System.out.println("isSimilar: " + isSimilar(new int[]{1, 5, 6, 78}, new int[]{1, 5, 6, 78, 9}));
        System.out.println("isSimilar: " + isSimilar(new int[]{1, 5, 6, 78, 10}, new int[]{1, 5, 6, 78}));
        System.out.println("isSimilar: " + isSimilar(new int[]{1, 5, 6, 78, 10}, new int[]{1, 5, 8, 6, 78}));
        System.out.println("shiftIndex: " + Arrays.toString(shiftIndex(new int[]{10, 11, 12, 3, 1, 2})));
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы не пустые и имеют одинаковую длину.
     * В остальных случаях - false.
     */
    static boolean isEqualSize(int[] arr1, int[] arr2) {
        return arr1.length > 0 && arr2.length > 0 && arr1.length == arr2.length;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если массивы полностью идентичны по составу.
     * В остальных случаях - false.
     *
     * <p>Идентичными считаются массивы одинаковой длины, для которых arr1[i] == arr2[i] для любого i.
     */
    static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!(arr1[i] == arr2[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Реализуйте метод, который принимает параметром массив целых чисел.
     * И возвращает массив, в котором каждый элемент исходного увеличен на единицу.
     *
     * <p>Для пустого массива должен быть возвращен пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [10,20,30,40,50,20,60]
     *
     * <p>Возвращаемое значение: [11,21,31,41,51,21,61]
     */
    static int[] incrementEach(int[] arr) {
        if (isEmpty(arr)) {
            return new int[] {};
        }

        int[] result = arr.clone();

        for (int i = 0; i < result.length; i++) {
            result[i]++;
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметрами два массива целых чисел: arr1 и arr2.
     * И возвращает массив, в котором каждый result[i] - произведение arr1[i] и arr2[i].
     *
     * <p>Если массивы разной длины - недостающие значения более короткого
     * массива необходимо считать как 0.
     *
     * <p>В случае с двумя пустыми массивами необходимо вернуть пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [2,3,4], [4,5,6]
     *
     * <p>Возвращаемое значение: [8,15,24]
     */
    static int[] multiplyEach(int[] arr1, int[] arr2) {
        if (isEmpty(arr1) && isEmpty(arr2)) {
            return new int[] {};
        }

        int minSize = Math.min(arr1.length, arr2.length);

        int[] result = new int[Math.max(arr1.length, arr2.length)];

        for (int i = 0; i < minSize; i++) {
            result[i] = arr1[i] * arr2[i];
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметрами два массива целых чисел: arr1 и arr2.
     * И возвращает массив, в котором каждый result[i] - разность arr1[i] и arr2[i].
     *
     * <p>Если массивы разной длины - недостающие значения более короткого
     * массива необходимо считать как 0.
     *
     * <p>В случае с двумя пустыми массивами необходимо вернуть пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [2,3,6], [4,5,4]
     *
     * <p>Возвращаемое значение: [-2,-2,2]
     */
    static int[] subtractEach(int[] arr1, int[] arr2) {
        if (isEmpty(arr1) && isEmpty(arr2)) {
            return new int[] {};
        }

        int[] result = new int[Math.max(arr1.length, arr2.length)];

        for (int i = 0; i < result.length; i++) {
            if (i > arr1.length - 1) {
                result[i] = -arr2[i];
                continue;
            }

            if (i > arr2.length - 1) {
                result[i] = arr1[i];
                continue;
            }

            result[i] = arr1[i] - arr2[i];
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметром массив целых чисел.
     * И возвращает массив, развернутый в обратном порядке.
     *
     * <p>Для пустого массива должен быть возвращен пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [2,3,4],
     *
     * <p>Возвращаемое значение: [4,3,2]
     */
    static int[] reverse(int[] arr) {
        if (isEmpty(arr)) {
            return new int[] {};
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[arr.length - 1 - i] = arr[i];
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел, индекс массива и целое число.
     * И возвращает массив, в котором число вставлено по указанному индексу в исходный массив.
     * Остальные элементы массива должны быть сдвинуты вправо.
     *
     * <p>Если индекс превышает длину массива - число добавляется в конец массива.
     * Если индекс некорректный (например, отрицательный), метод должен вернуть пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [1,2,3,4], 2, 456
     *
     * <p>Возвращаемое значение: [1,2,456,3,4]
     */
    static int[] add(int[] arr, int index, int newValue) {
        if (index < 0) {
            return new int[] {};
        }

        int[] result = new int[arr.length + 1];

        if (index > arr.length - 1) {
            for (int i = 0; i < arr.length; i++) {
                result[i] = arr[i];
            }

            result[result.length - 1] = newValue;
        }

        int resultIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                result[resultIndex] = newValue;
                index = -1;
                i--;
            } else {
                result[resultIndex] = arr[i];
            }

            resultIndex++;
        }

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если переданный параметром массив содержит указанное число.
     * В остальных случаях - false.
     */
    static boolean isContains(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел и искомое целое число.
     * И возвращает минимальный индекс, на котором найдет данное число в массиве.
     *
     * <p>Если в массиве нет искомого элемента - метод должен вернуть -1.
     *
     * <p>Пример 1:
     *
     * <ul>
     * <li>Входные данные: [10,20,30,40,50,20,60], 20
     * <li>Возвращаемое значение: 1
     * </ul>
     *
     * <p>Пример 2:
     *
     * <ul>
     * <li>Входные данные: [10,30,40,50,60], 20
     * <li>Возвращаемое значение: -1
     * </ul>
     */
    static int getFirstIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел и искомое целое число.
     * И возвращает максимальный индекс, на котором найдет данное число в массиве.
     *
     * <p>Если в массиве нет искомого элемента - метод должен вернуть -1.
     *
     * <p>Пример 1:
     *
     * <ul>
     * <li>Входные данные: [10,20,30,40,50,20,60], 20
     * <li>Возвращаемое значение: 5
     * </ul>
     *
     * <p>Пример 2:
     *
     * <ul>
     * <li>Входные данные: [10,30,40,50,60], 20
     * <li>Возвращаемое значение: -1
     * </ul>
     */
    static int getLastIndex(int[] arr, int value) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел и целое число - индекс.
     * И возвращает массив без значения по указанному индексу. Другие значения должны быть сдвинуты влево.
     *
     * <p>Если указанный индекс выходит за пределы массива - метод должен вернуть копию исходного массива.
     * Если индекс некорректный - метод должен вернуть пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [10,20,30,40,50,20,60], 2
     * <p>Возвращаемое значение: [10,20,40,50,20,60]
     */
    static int[] removeByIndex(int[] arr, int index) {
        if (index > arr.length - 1) {
            return  arr.clone();
        }

        if (index < 0) {
            return new int[] {};
        }

        int[] result = new int[arr.length - 1];
        int resultIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                result[resultIndex++] = arr[i];
            }
        }

        return result;
    }

    /**
     * Реализуйте метод, который принимает параметрами массив целых чисел и
     * еще один массив целых чисел (в виде varargs).
     * И возвращает первый массив, удалив из него все числа, которые есть во втором.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [10,20,30,40,50,20,60], [20,23,30]
     * <p>Возвращаемое значение: [10,40,50,60]
     */
    static int[] removeAll(int[] arr, int... removingValues) {
        int[] result = arr.clone();
        int index;

        for (int i = 0; i < removingValues.length; i++) {
            index = getFirstIndex(result, removingValues[i]);

            if (index != -1) {
                result = removeByIndex(result, index);
                i--;
            }
        }

        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать true,
     * если все числа из первого массива присутствуют во втором
     * и все числа из второго массива присутствуют в первом.
     * При этом индексы элементов могут не совпадать.
     */
    static boolean isSimilar(int[] arr1, int[] arr2) {
        return isFoundAllElements(arr1, arr2) && (isFoundAllElements(arr2, arr1));
    }

    /**
     * Реализуйте метод, который принимает параметром массив целых чисел.
     * И возвращает массив, сдвинув все элементы входящего массива на следующий индекс.
     * При этом последний элемент будет перенесен на нулевой индекс.
     *
     * <p> Для пустого массива должен быть возвращен пустой массив.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [1,2,3,4]
     * <p>Возвращаемое значение: [4,1,2,3]
     */
    static int[] shiftIndex(int[] arr) {
        if (isEmpty(arr)) {
            return new int[] {};
        }

        int[] result = arr.clone();

        for (int i = result.length - 1; i > 0; i--) {
            result[i] = result[i - 1];
        }

        result[0] = arr[arr.length - 1];

        return result;
    }

    private static boolean isEmpty(int[] arr) {
        return arr.length < 1;
    }

    private static boolean isFoundAllElements(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            if (getFirstIndex(arr1, arr2[i]) == -1) {
                return false;
            }
        }

        return true;
    }
}
