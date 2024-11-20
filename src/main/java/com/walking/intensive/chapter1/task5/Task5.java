package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
        double a = 12;
        double b = 13;
        double c = 5;

        System.out.printf("Площадь по Герону: %.2f", getAreaByHeron(a, b, c));
        System.out.printf("\nПлощадь по т. Косинусов: %.2f", getAreaAdvanced(a, b, c));

        System.out.print("\nВысоты: ");

        double[] heights = getHeights(a, b, c);

        for (double height : heights) {
            System.out.printf("%.2f ", height);
        }

        System.out.print("\nМедианы: ");

        double[] medians = getMedians(a, b, c);

        for (double median : medians) {
            System.out.printf("%.2f ", median);
        }

        System.out.print("\nБиссектрисы: ");

        double[] bisectors = getBisectors(a, b, c);

        for (double bisector : bisectors) {
            System.out.printf("%.2f ", bisector);
        }

        System.out.print("\nУглы: ");

        double[] angles = getAngles(a, b, c);

        for (double angle : angles) {
            System.out.printf("%.2f ", angle);
        }

        System.out.printf("\nРадиус вписанной окружности: %.2f", getInscribedCircleRadius(a, b, c));
        System.out.printf("\nРадиус описанной окружности: %.2f", getCircumradius(a, b, c));
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        if (!isValidParams(a, b, c)) {
            return -1;
        }

        double halfPerimeter = getHalfPerimeter(a, b, c);

        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        double s = getAreaByHeron(a, b, c);

        if (s == -1) {
            return new double[0];
        }

        double heightA = (2 * s) / a;
        double heightB = (2 * s) / b;
        double heightC = (2 * s) / c;

        double[] heights = new double[]{heightA, heightB, heightC};
        Arrays.sort(heights);

        return heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (!isValidParams(a, b, c)) {
            return new double[0];
        }

        double medianA = Math.sqrt(2 * (b * b + c * c) - a * a) / 2;
        double medianB = Math.sqrt(2 * (a * a + c * c) - b * b) / 2;
        double medianC = Math.sqrt(2 * (a * a + b * b) - c * c) / 2;

        double[] medians = new double[]{medianA, medianB, medianC};
        Arrays.sort(medians);

        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (!isValidParams(a, b, c)) {
            return new double[0];
        }

        double bisectorA = Math.sqrt(b * c * (b + c + a) * (b + c - a)) / (b + c);
        double bisectorB = Math.sqrt(a * c * (a + c + b) * (a + c - b)) / (a + c);
        double bisectorC = Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);

        double[] bisectors = new double[]{bisectorA, bisectorB, bisectorC};
        Arrays.sort(bisectors);

        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (!isValidParams(a, b, c)) {
            return new double[0];
        }

        double cosA = (b * b + c * c - a * a) / (2 * b * c);
        double cosB = (a * a + c * c - b * b) / (2 * a * c);
        double cosC = (a * a + b * b - c * c) / (2 * a * b);

        double angleA = Math.toDegrees(Math.acos(cosA));
        double angleB = Math.toDegrees(Math.acos(cosB));
        double angleC = Math.toDegrees(Math.acos(cosC));

        double[] angles = new double[]{angleA, angleB, angleC};
        Arrays.sort(angles);

        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (!isValidParams(a, b, c)) {
            return -1;
        }

        return getAreaByHeron(a, b, c) / getHalfPerimeter(a, b, c);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (!isValidParams(a, b, c)) {
            return -1;
        }

        return (a * b * c) / (4 * getAreaByHeron(a, b, c));
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if (!isValidParams(a, b, c)) {
            return -1;
        }

        double cosA = (b * b + c * c - a * a) / (2 * b * c);
        double sinA = Math.sqrt(1 - cosA * cosA);

        return (b * c * sinA) / 2;
    }

    private static double getHalfPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    private static boolean isValidParams(double a, double b, double c) {
        return (a > 0 && b > 0 && c > 0) && ((a + b > c) && (a + c > b) && (b + c > a));
    }
}
