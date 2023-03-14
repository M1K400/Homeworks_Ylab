package Guess;

import java.util.Random;
import java.util.Scanner;


/**
 *
 *
 * Игра угадайка. При запуске программа загадывает число от 1 до 99 (включительно) и
 * дает пользователю 10 попыток отгадать. Далее пользователь начинает вводить число. И тут возможен один из следующих вариантов:
 *
 * - Пользователь отгадал число. В таком случае выводится строка
 * “Ты угадал с N попытки”, где N - номер текущей попытки пользователя
 * - Пользователь ввел число, меньше загаданного. В таком случае выводится сообщение “Мое число меньше! У тебя осталось M попыток” где M - количество оставшихся попыток
 * - Пользователь ввел число, больше загаданного. В таком случае выводится сообщение “Мое число больше! У тебя осталось M попыток” где M - количество оставшихся попыток
 * - У пользователя закончились попытки и число не было угадано. В таком случае выводится сообщение “Ты не угадал”
 *
 * Получить случайный элемент от 1 до 99 (включительно):
 * int number = new Random().nextInt(99) + 1;
 *
 *
 *
 *
 * */

public class HW4 {

    public static void main(String[] args) {
        int number = new Random().nextInt(100); // здесь загадывается число от 1 до 99
        int maxAttempts = 10; // здесь задается количество попыток
        System.out.println("Я загадал число. У тебя " + maxAttempts + " попыток угадать.");
        guessGame(number,maxAttempts);

    }

    public static void guessGame(int number,int maxAttempt){
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 1; i <= maxAttempt; i++){
                System.out.print("Число: ");
                int n = scanner.nextInt();
                int countAttempt = maxAttempt - i;
                if (n == number){
                    System.out.println("Ты угадал с " + countAttempt + " попытки !");
                    break;
                } else if (n < number){
                    System.out.println("Моё число больше ! Осталось " + countAttempt + " попыток");
                } else {
                    System.out.println("Моё число меньше ! Осталось " + countAttempt + " попыток");
                }
            }
            System.out.println("Ты не угадал !");
        } catch (RuntimeException ex){
            System.out.println("Произошла ошибка при выполнения программы: " + ex.fillInStackTrace());
        }
    }



}
