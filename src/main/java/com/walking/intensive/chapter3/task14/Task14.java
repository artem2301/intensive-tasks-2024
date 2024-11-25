package com.walking.intensive.chapter3.task14;

/**
 * Необходимо разработать программу, которая определяет количество объектов на радарах.
 *
 * <p>Реализуйте метод getObjectCounts(), который произведет указанный расчет.
 *
 * <p>Входящие параметры метода:
 *
 * <ol>
 * <li>Двумерный массив с координатами объектов, где любой objectLocations[i]
 *      содержит массив из двух точек - координат объекта по осям X и по Y соответственно;
 * <li>Двумерный массив с параметрами радаров, где любой radars[j] содержит массив со следующими данными:
 *      radars[j][0] - координата радара по оси X, radars[j][1] - координата радара по оси Y,
 *      radars[j][2] - радиус действия радара
 * </ol>
 *
 * <p>Возвращаемое значение метода - количество объектов, видимых на каждом из радаров:
 * objectCounts[j] должен содержать информацию о числе объектов, видимых на радаре radars[j].
 *
 * <p>Если объект находится точно на границе действия радара, считается,
 * что он попадает в зону действия этого радара.
 *
 * <p>Пример:
 *
 * <p>Входящие параметры: objectLocations[][] = [[1,3],[3,3],[5,3],[2,2]], radars[][] = [[2,3,1],[4,3,1],[1,1,2]].
 *
 * <p>Возвращаемое значение: objectCounts[] = [3,2,2].
 *
 * <p>Пояснение (для radars[0]):
 *
 * <ul>
 * <li>objectCounts[0] = 3, потому что радар с координатами (2;3) и радиусом действия 1 видит объекты с координатами
 * (1;3), (2;2) и (3;3). Всего 3 объекта.
 *</ul>
 *
 * <p>При наличии некорректных входных данных верните из метода пустой массив.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task14 {
    public static void main(String[] args) {
        int[] result = getObjectCounts(getObjectLocations(), getRadarList());

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static int[] getObjectCounts(int[][] objectLocations, int[][] radars) {
        if (!isCorrectData(objectLocations, radars)) {
            return new int[0];
        }

        int[] objectCounts = new int[radars.length];

        double sumSquaresXY, squareRadius;

        for (int i = 0; i < radars.length; i++) {
            for (int j = 0; j < objectLocations.length; j++) {
                sumSquaresXY = Math.pow(objectLocations[j][0] - radars[i][0], 2) + Math.pow(objectLocations[j][1] - radars[i][1], 2);
                squareRadius = Math.pow(radars[i][2], 2);

                if ((sumSquaresXY == squareRadius) || sumSquaresXY < squareRadius) {
                    objectCounts[i]++;
                }
            }
        }

        return objectCounts;
    }

    private static boolean isCorrectData(int[][] objectLocations, int[][] radars) {
        if (objectLocations == null || objectLocations.length == 0 || radars == null || radars.length == 0) {
            return false;
        }

        for (int i = 0; i < objectLocations.length; i++) {
            if (objectLocations[i].length != 2) {
                return false;
            }
        }

        for (int i = 0; i < radars.length; i++) {
            if (radars[i].length != 3 || radars[i][2] < 1) {
                return false;
            }
        }

        return true;
    }

    private static int[][] getObjectLocations() {
        return new int[][] {
                {1, 3},
                {3, 3},
                {5, 3},
                {2, 2}
        };
    }

    private static int[][] getRadarList() {
        return new int[][] {
                {2, 3, 1},
                {4, 3, 1},
                {1, 1, 2}
        };
    }
}
