package Transliterator;

import Transliterator.repository.TransliteratorImpl;

import java.util.Scanner;

public class TransliteratorTest {


    private static final TransliteratorImpl transliterator = new TransliteratorImpl();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){

            System.out.println("Напишите какой нибудь текст.");
            System.out.print("Текст: ");
            String text = scanner.nextLine();
            System.out.println("Результат: " + transliterator.transliterate(text) + "\n");
            System.out.println("Тестовый образец: ");
            System.out.println("Был: HELLO! приветики пистолетики ПРИВЕТ! Go, boy!\nСтал: " + transliterator.transliterate("HELLO! приветики пистолетики ПРИВЕТ! Go, boy!"));

        } catch (RuntimeException ex){
            System.out.println("Произошла ошибка при работе программы: "  + ex.getMessage());
        }

    }
}
