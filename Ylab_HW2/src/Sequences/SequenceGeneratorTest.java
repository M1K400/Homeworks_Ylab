package Sequences;

import Sequences.repository.SequenceGeneratorImpl;

import java.util.Scanner;


public class SequenceGeneratorTest {

    /**
     * Создаём объект SequenceGeneratorImpl в котором мы реализовали.
     * Кстати можно реализовать данные закономерности через Stream API, но я не стал этим заниматься.
     */
    private static final SequenceGeneratorImpl sequenceGenerator = new SequenceGeneratorImpl();



    public static void main(String[] args) {
        //Try с ресурсами.
        try (Scanner scanner = new Scanner(System.in)) {
            //Требуем от пользователя необходимое количество элементов.
            System.out.print("Введите количество элементов: ");
            int valueSequence = scanner.nextInt();

            sequenceGenerator.a(valueSequence);
            sequenceGenerator.b(valueSequence);
            sequenceGenerator.c(valueSequence);
            sequenceGenerator.d(valueSequence);
            sequenceGenerator.e(valueSequence);
            sequenceGenerator.f(valueSequence);
            sequenceGenerator.g(valueSequence);
            sequenceGenerator.h(valueSequence);
            sequenceGenerator.i(valueSequence);
            sequenceGenerator.j(valueSequence);


            //В случай если будет ошибка при выполнение программы.
        } catch (RuntimeException ex) {
            System.out.println("Произошла ошибка при выполнения работы программы: " + ex.fillInStackTrace());
        }

    }




}
