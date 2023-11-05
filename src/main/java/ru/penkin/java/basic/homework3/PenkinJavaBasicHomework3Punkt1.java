package ru.penkin.java.basic.homework3;

// Основная ветка на github.

import java.util.Scanner;

public class PenkinJavaBasicHomework3Punkt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.println("Домашнее задание 3, введите номер метода от 1 до 5:");
        System.out.println("---------------------------------------------------");
        System.out.println("1 - метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив, метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;");
        System.out.println("2 - метод, который принимает в качестве аргумента int size и печатает в консоль квадрат из символов * со сторонами соответствующей длин;");
        System.out.println("3 - метод, принимающий в качестве аргумента квадратный двумерный целочисленный массив, и зануляющий его диагональные элементы;");
        System.out.println("4 - метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;");
        System.out.println("5 - метод, который считает сумму элементов второй строки или столбца двумерного массива (по вашему выбору), если второй строки/столбца не существует, то в качестве результата необходимо вернуть -1.");
                        int scan = scanner.nextInt();

        if (scan == 1) {
            int[][] OneArray = {{4, 15, -3, 2, -8}, {-4, -9, 8, 5, -7}, {7, 8, 9, -3, 14}};
            int result = Metod_1_sumOfPositiveElements(OneArray);
            System.out.println("Сумма элементов массива, которые больше нуля: " + result);
        }

        if (scan == 2) {
            int size = 7;    // Изменение размера квадрата
            Metod_2(size);
        }

        if (scan == 3) {
            int[][] TwoArray = {
                    {9, 2, 7, 4},
                    {4, 5, 4, 6},
                    {3, 6, 7, 1},
                    {7, 8, 9, 4}
            };

            Metod_3(TwoArray);
            for (int i = 0; i < TwoArray.length; i++) {
                for (int j = 0; j < TwoArray[i].length; j++) {
                    System.out.print(TwoArray[i][j] + " ");
                }
                System.out.println();
            }
        }

        if (scan == 4) {
            int[][] ThreeArray = {
                    {10, 8, 16, 8},
                    {21, 11, 4, 19},
                    {14, 16, 17, 15},
                    {7, 150, 23, 20}
            };
            int maxElement = Metod_4_findMax(ThreeArray);
            System.out.println("Максимальный элемент в массиве: " + maxElement);
        }

        if (scan == 5) {
            int[][] FourArray = {
                    {10, 85, 16, 8},
                    {21, 115, 4, 19},
                    {14, 165, 17, 15},
                    {7, 155, 23, 20}
            };
            int rowSum = Metod_5(FourArray, true);
            int colSum = Metod_5(FourArray, false);

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите 1 для расчета и вывода суммы элементов второй строки или 2 для расчета и вывода суммы элементов второго столбца");
            int scan1 = scanner.nextInt(); {
                if (scan1 == 1) {
                    System.out.println("Сумма элементов второй строки: " + rowSum);
                }
                if (scan1 == 2) {
                    System.out.println("Сумма элементов второго столбца: " + colSum);
                }
            }
        }
    }

    public static int Metod_1_sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }

    public static void Metod_2(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void Metod_3(int[][] TwoArray) {
        int n = TwoArray.length;         // Размер квадратного двумерного массива

        for (int i = 0; i < n; i++) {    // Зануляется первая диагональ
            TwoArray[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {    // Зануляется вторая диагональ
            TwoArray[i][n - 1 - i] = 0;
        }
    }

    public static int Metod_4_findMax(int[][] ThreeArray) {
        if (ThreeArray == null || ThreeArray.length == 0 || ThreeArray[0].length == 0) {    // Проверяем, что массив не пустой
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        int maxElement = ThreeArray[0][0];                   // Создается переменная для хранения максимального элемента

        for (int i = 0; i < ThreeArray.length; i++) {        // Проход по всем элементам массива
            for (int j = 0; j < ThreeArray[i].length; j++) {
                if (ThreeArray[i][j] > maxElement) {         // Если текущий элемент больше текущего максимального, обновляем максимальный элемент
                    maxElement = ThreeArray[i][j];
                }
            }
        }
        return maxElement;     // Возвращается максимальный элемент массива
    }

    public static int Metod_5(int[][] FourArray, boolean calculateRow) {
        if (FourArray == null || FourArray.length < 2) {
            return -1; // Проверка на существование хотя бы двух строк.
        }

        int rowCount = FourArray.length;
        int colCount = FourArray[0].length;

        if (calculateRow && rowCount < 2) {
            return -1; // Если второй строки нет
        }

        if (!calculateRow && colCount < 2) {
            return -1; // Если второго столбца нет
        }

        int sum = 0;

        if (calculateRow) {
            for (int j = 0; j < colCount; j++) {
                sum += FourArray[1][j]; // Считается сумма элементов второй строки
            }
        } else {
            for (int i = 0; i < rowCount; i++) {
                sum += FourArray[i][1]; // Считается сумма элементов второго столбца
            }
        }
        return sum;
    }
}