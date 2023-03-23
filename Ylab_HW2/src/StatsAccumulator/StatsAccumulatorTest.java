package StatsAccumulator;

import StatsAccumulator.repository.StatsAccumulatorImpl;

import java.util.Scanner;

public class StatsAccumulatorTest {


    private static final StatsAccumulatorImpl statsAccumulator = new StatsAccumulatorImpl();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Добро пожаловать !\nВыберите одно из действий\n");
            whileWork:{
                while (true){
                    System.out.println("Добавить число - 1");
                    System.out.println("Узнать количество чисел - 2");
                    System.out.println("Узнать среднее значение - 3");
                    System.out.println("Узнать максимальное значение - 4");
                    System.out.println("Узнать минимальное значение - 5");
                    System.out.println("Выйти из приложения - 0\n");
                    System.out.print("Номер команды: ");
                    int numberCommand = scanner.nextInt();
                    switch (numberCommand) {
                        case 0 -> { break whileWork; }
                        case 1 -> {
                            System.out.print("Введите число: ");int value = scanner.nextInt();
                            statsAccumulator.add(value); }
                        case 2 -> System.out.println("Количество чисел: " + statsAccumulator.getCount() + "\n");
                        case 3 -> System.out.println("Среднее значение: " + statsAccumulator.getAvg() + "\n");
                        case 4 -> System.out.println("Максимальное значение: " + statsAccumulator.getMax() + "\n");
                        case 5 -> System.out.println("Минимальное значение: " + statsAccumulator.getMin() + "\n");
                        default -> System.out.println("Непонятная команда, пожалуйста, введите другую команду.\n");
                    }
                }
            }

        } catch (RuntimeException ex){
            System.out.println("Произошла ошибка при работе программы: "  + ex.fillInStackTrace());
        }

    }

}
