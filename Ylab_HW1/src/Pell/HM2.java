package Pell;

import java.util.Scanner;

/**
 *
 *
 *
 * Pell numbers Числа Пелля задаются следующим соотношением:
 *
 *
 * если n = 0, то число равно 0
 * если n = 1, то число равно 1
 * если n > 1, то происходит расчёт по такой формуле 2 * P(n-1) + P(n-2)
 *
 * На вход подается число n (0 <= n <= 30), необходимо распечатать n-e число Пелля
 * Пример:
 * Ввод:
 * 5
 * Вывод:
 * 29
 *
 *
 *
 * */

public class HM2 {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число в диапозоне от 0 до 30 включительно: ");
            int n = scanner.nextInt();
            if ( n >= 0 && n <= 30){
                System.out.println("Ответ: " + pellNumber(n));
            } else {
                System.out.println("Ошибка: число вышло из данного диапозона");
            }
        } catch (RuntimeException ex){
            System.out.println("Произошла ошибка при выполнения программы: " + ex.fillInStackTrace());
        }
    }


    private static int pellNumber(int value){
        int res;
        if (value == 0){
            return 0;
        }
        if (value == 1){
            return 1;
        }
        res = 2*pellNumber(value-1) + pellNumber(value - 2);
        return res;
    }


}
