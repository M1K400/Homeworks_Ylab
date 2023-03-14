package SnilsValidator;

import SnilsValidator.repository.SnilsValidatorImpl;

import java.util.Scanner;

public class SnilsValidatorTest {

    private final static SnilsValidatorImpl snilsValidator = new SnilsValidatorImpl();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Пожалуйтса введите снилс под один из форматов приведённых ниже\n1 формат: XXX-XXX-XXX-XX\n2 формат: XXX-XXX-XXX XX\n3 формат: XXXXXXXXXXX\nВаш снилс:");
            String snils = scanner.nextLine();

            System.out.println("\nТестовые образцы работы программы");
            System.out.println("Результат снилса такого формата 90114404441: " + snilsValidator.validate("90114404441"));
            System.out.println("Результат снилса такого формата 901-144-044-41: " + snilsValidator.validate("901-144-044-41"));
            System.out.println("Результат снилса такого формата 901-144-044 39: " + snilsValidator.validate("901-144-044 39"));
            System.out.println("Ваш результат снилса " + snils + ": " + snilsValidator.validate(snils));

        } catch (RuntimeException ex){
            System.out.println("Произошла ошибка при работе программы: "  + ex.fillInStackTrace());
        }
    }
}
