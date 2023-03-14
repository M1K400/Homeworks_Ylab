package Stars;

import java.util.Scanner;


/**
 *
 *
 * Программе передается 3 параметра: количество строк, количество столбцов,
 * произвольный симов. Необходимо вывести вывести фигуру, состоящую из заданного
 * списка строк и заданного количества столбцов, и каждый элемент в которой равен указанному символу.
 *
 * Ввод: n m c
 * Вывод: фигура
 *
 * Пример:
 * Ввод:
 * 2 3 $
 * Вывод:
 * $ $ $
 * $ $ $
 *
 *
 *
 *
 * */



public class HM1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Количество строк: ");
            int n = scanner.nextInt();
            System.out.print("Количество столбцов: ");
            int m = scanner.nextInt();
            System.out.print("Произвольный символ: ");
            String template = scanner.next();

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j ++){
                    System.out.print(template + "\t");
                }
                System.out.println();
            }
        } catch (RuntimeException ex){
            System.out.println("Произошла ошибка при выполнения программы: " + ex.fillInStackTrace());
        }
    }

}
