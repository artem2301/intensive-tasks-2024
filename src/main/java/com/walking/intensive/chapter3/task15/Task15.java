package com.walking.intensive.chapter3.task15;

/**
 * Существует город, состоящий из N x N блоков, где каждый блок содержит одно здание в форме вертикальной
 * квадратной призмы. Линия горизонта города — это внешний контур, образованный всеми зданиями,
 * если смотреть на город издалека. Линия горизонта с каждого из сторон света — севера,
 * востока, юга и запада — может отличаться.
 *
 * <p>Каждое здание имеет определенную высоту, измеряемую в этажах.
 *
 * <p>Разрешено увеличивать высоту любого количества зданий на любую величину этажей
 * (величина может быть разной для каждого здания). Высота здания с нулевой высотой также может быть увеличена.
 * Увеличение высоты здания не должно повлиять на горизонт города ни с какой стороны света.
 *
 * <p>Реализуйте метод getMaxFloors() с учетом условий ниже.
 *
 * <p>Входящий параметр: массив city[][], где city[r][c] представляет высоту здания,
 * расположенного в блоке в строке r и столбце c. Высота здания не может быть отрицательной.
 *
 * <p>Возвращаемое значение: максимально возможное количество достроенных этажей,
 * на которое можно увеличить высоту зданий без изменения горизонта города
 * с любого направления по сторонам света.
 *
 * <p>Пример:
 *
 * <p>Входящий массив: city[ ][ ] = [[2,1],[1,3]].
 *
 * <p>Возвращаемое значение: 2.
 *
 * <p>Пояснение: всего 4 здания, 2 из которых имеют по 1 этажу, 1 здание - 2 этажа и 1 здание - 3 этажа.
 * Можно добавить максимум по 1 этажу к каждому одноэтажному дому чтобы ни одна из 4 линий горизонта не поменялась.
 * Итого 2 этажа.
 *
 * <p>При наличии некорректных входных данных верните из метода -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task15 {
    public static void main(String[] args) {
        System.out.println(getMaxFloors(new int[][] {
                {2, 1},
                {1, 3}}));
    }

    static int getMaxFloors(int[][] city) {
        if (!isCorrectArray(city)) {
            return -1;
        }

        int[][] maxRowsAndColumns = new int[city.length][city.length];

        for (int i = 0; i < city.length; i++) {
            maxRowsAndColumns[0][i] = city[i][0];
            maxRowsAndColumns[1][i] = city[0][i];

            for (int j = 1; j < city[i].length; j++) {
                if (city[i][j] > maxRowsAndColumns[0][i]) {
                    maxRowsAndColumns[0][i] = city[i][j];
                }
            }

            for (int j = 1; j < city.length; j++) {
                if (city[j][i] > maxRowsAndColumns[1][i]) {
                    maxRowsAndColumns[1][i] = city[j][i];
                }
            }
        }

        int min;
        int count = 0;

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city[i].length; j++) {
                min = Math.min(maxRowsAndColumns[0][i], maxRowsAndColumns[1][j]);

                if (city[i][j] < min) {
                    count += min - city[i][j];
                }
            }
        }

        return count;
    }

    private static boolean isCorrectArray(int[][] arr) {
        return isCorrectArraySize(arr) && !isEmptyElements(arr) && isAllPositiveElements(arr);
    }

    private static boolean isAllPositiveElements(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isCorrectArraySize(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arr.length) {
                return false;
            }
        }

        return true;
    }

    private static boolean isEmptyElements(int[][] arr) {
        if (arr.length < 1) {
            return true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length < 1) {
                return true;
            }
        }

        return false;
    }
}
