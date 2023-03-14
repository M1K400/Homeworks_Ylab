package ComplexNumbers.repository;

public class ComplexNumbersImpl implements ComplexNumbers {

    /**
     *
     * Выполняет сложение комплексных чисел
     *
     */

    @Override
    public Complex additionComplexNumbers(Complex complex1, Complex complex2) {
        double real = complex1.getmRe() + complex2.getmRe();
        double imag = complex2.getmIm() + complex2.getmIm();
        return new Complex(real,imag);
    }


    /**
     *
     * Выполняет вычитание комплексных чисел
     *
     */

    @Override
    public Complex subtractionComplexNumbers(Complex complex1, Complex complex2) {
        double real = complex1.getmRe() - complex2.getmRe();
        double imag = complex1.getmIm() - complex2.getmIm();
        return new Complex(real,imag);
    }


    /**
     *
     * Выполняет умножение комплексных чисел
     *
     */
    @Override
    public Complex multiplicationComplexNumbers(Complex complex1, Complex complex2) {
        double real = complex1.getmRe() * complex2.getmRe() - complex1.getmIm() * complex2.getmIm();
        double imag = complex1.getmRe() * complex2.getmIm() + complex1.getmIm() * complex2.getmRe();
        return new Complex(real,imag);

    }


    /**
     *
     * Вычисляет модуль числа.
     *
     */
    @Override
    public double moduleComplexNumbers(Complex complex) {
        return  Math.hypot(complex.getmRe(),complex.getmIm());
    }


}
