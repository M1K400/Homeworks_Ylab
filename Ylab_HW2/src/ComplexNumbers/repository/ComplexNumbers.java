package ComplexNumbers.repository;

public interface ComplexNumbers {

    /**
     *
     * Выполняет сложение комплексных чисел
     *
     */
    Complex additionComplexNumbers(Complex complex1, Complex complex2);


    /**
     *
     * Выполняет вычитание комплексных чисел
     *
     */
    Complex subtractionComplexNumbers(Complex complex1, Complex complex2);

    /**
     *
     * Выполняет умножение комплексных чисел
     *
     */
    Complex multiplicationComplexNumbers(Complex complex1, Complex complex2);

    /**
     *
     * Вычисляет модуль числа.
     *
     */
    double moduleComplexNumbers(Complex complex);






}
