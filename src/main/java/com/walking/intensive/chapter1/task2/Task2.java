package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    private static final int COUNT_FLATS_ON_FLOOR = 4;

    public static void main(String[] args) {
        System.out.println(getFlatLocation(10, 10, 23));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        if (floorAmount < 0 || entranceAmount < 0 || flatNumber < 0) {
            return "Некорректные входные данные";
        }

        if (flatNumber > (COUNT_FLATS_ON_FLOOR * floorAmount * entranceAmount)) {
            return "Такой квартиры не существует";
        }

        // Узнаем подъезд

        int floorCounts = COUNT_FLATS_ON_FLOOR * floorAmount;
        int nEntrance = flatNumber / floorCounts;

        if (flatNumber % floorAmount != 0) {
            nEntrance++;
        }

        // Узнаем этаж

        int nFloor = (flatNumber - ((nEntrance - 1) * floorCounts)) / 4;

        // Узнаем направление относительно лифта

        String elevatorPosition;

        int floorIndex = flatNumber % COUNT_FLATS_ON_FLOOR;

        switch (floorIndex) {
            case 1, 2:
                elevatorPosition = "слева";
                break;
            default:
                elevatorPosition = "справа";
        }

        // Узнаем сторону квартиры

        String flatPosition;

        if (elevatorPosition.equals("слева") && (floorIndex == 1)
                || (elevatorPosition.equals("справа") && (floorIndex == 3))) {
            flatPosition = "влево";
        } else {
            flatPosition = "вправо";
        }

        return flatNumber + " кв - " + nEntrance + " подъезд, "
                + nFloor + " этаж, "
                + elevatorPosition + " от лифта, "
                + flatPosition;
    }
}
