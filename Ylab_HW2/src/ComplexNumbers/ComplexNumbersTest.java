package ComplexNumbers;

import ComplexNumbers.repository.Complex;
import ComplexNumbers.repository.ComplexNumbersImpl;

import java.util.Scanner;

public class ComplexNumbersTest {

    private static final ComplexNumbersImpl complexNumbersImpl = new ComplexNumbersImpl();

    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Введите действительное комплексное число: ");
            double re = scanner.nextDouble();
            System.out.print("Введите не действительное комплексное число: ");
            double im = scanner.nextDouble();
            Complex ob1=new Complex(re,im);
            Complex ob2=new Complex(11,22);
            System.out.println("Результат сложения: " + complexNumbersImpl.additionComplexNumbers(ob1,ob2).toString());
            System.out.println("Результат вычитания: " + complexNumbersImpl.subtractionComplexNumbers(ob1,ob2).toString());
            System.out.println("Результат умножения: " + complexNumbersImpl.multiplicationComplexNumbers(ob1,ob2).toString());
            System.out.println("Модуль 1 объекта: " + complexNumbersImpl.moduleComplexNumbers(ob1));
            System.out.println("Модуль 2 объекта: " + complexNumbersImpl.moduleComplexNumbers(ob2));


        } catch (RuntimeException ex) {
            System.out.println("Произошла ошибка при работе программы: "  + ex.fillInStackTrace());
        }

    }


}
