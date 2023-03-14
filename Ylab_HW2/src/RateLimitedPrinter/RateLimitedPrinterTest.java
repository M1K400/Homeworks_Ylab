package RateLimitedPrinter;

import RateLimitedPrinter.repository.RateLimitedPrinterImpl;

import java.util.Scanner;

public class RateLimitedPrinterTest {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Введите интервал: ");
            int interval = scanner.nextInt();

            long currentTimeBeforeCallMethod = System.currentTimeMillis();

            RateLimitedPrinterImpl rateLimitedPrinter = new RateLimitedPrinterImpl(interval);

            for (int i = 0; i < 1_000_000_000; i++) {
                rateLimitedPrinter.print(String.valueOf(i));
            }

            System.out.println("Текущее время до вызова: " + currentTimeBeforeCallMethod);
            System.out.println("Текущее время после вызова: " + System.currentTimeMillis());

        } catch (RuntimeException ex){
            System.out.println("Произошла ошибка при работе программы: "  + ex.fillInStackTrace());
        }

    }

}
