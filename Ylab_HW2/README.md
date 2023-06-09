# Второе домашнее задание. Коршунов Михаил


## Sequences ##

Последовательности A - J заданы в виде нескольких значений следующим образом

![image](https://user-images.githubusercontent.com/127130876/224946686-24535690-16f9-415f-8874-95fafe3b9d23.png)


Необходимо найти закономерности, по которым эти последовательности
сформированы и реализовать следующий интерфейс, каждый метод которого
принимает число N и выводит в консоль N элементов соответствующей
последовательности. Каждый элемент можно выводить с новой строки


```

public interface SequenceGenerator {
/**
* Выводит в консоль n первых членов последовательности A
* @param n число членов последовательности для вывода
*/
void a(int n);
/**
* Выводит в консоль n первых членов последовательности B
* @param n число членов последовательности для вывода
*/
void b(int n);
/**
* Выводит в консоль n первых членов последовательности C
* @param n число членов последовательности для вывода
*/
void c(int n);
/**
* Выводит в консоль n первых членов последовательности D
* @param n число членов последовательности для вывода
*/
void d(int n);
/**
* Выводит в консоль n первых членов последовательности E
* @param n число членов последовательности для вывода
*/
void e(int n);
/**
* Выводит в консоль n первых членов последовательности F
* @param n число членов последовательности для вывода
*/
void f(int n);
/**
* Выводит в консоль n первых членов последовательности G
* @param n число членов последовательности для вывода
*/
void g(int n);
/**
* Выводит в консоль n первых членов последовательности H
* @param n число членов последовательности для вывода
*/
void h(int n);
/**
* Выводит в консоль n первых членов последовательности I
* @param n число членов последовательности для вывода
*/
void i(int n);
/**
* Выводит в консоль n первых членов последовательности J
* @param n число членов последовательности для вывода
*/
void j(int n);
}

```


## Complex Numbers ##


Реализовать класс, описывающий комплексное число (действительная и мнимая часть
должны иметь точность double). Должны быть доступны следующие операции:

1. Cоздание нового числа по действительной части (конструктор с 1
параметром)

2. Создание нового числа по действительной и мнимой части (конструктор
с 2 параметрами)

3. Сложение

4. Вычитание

5. Умножение

6. Операция получения модуля

7. преобразование в строку (toString)
(арифметические действия должны создавать новый экземпляр класса)

Написать код, демонстрирующий работу с созданными классами


## RateLimitedPrinter ##

Реализовать класс RateLimiterPrinter. Класс имеет конструктор, в который передается
interval и метод print(), в который передается строка. Класс функционирует по
следующему принципу: на объекте класса вызывается метод print(). Далее идет
проверка, когда был последний вывод в консоль. Если интервал (в миллисекундах)
между последним состоявшимся выводом и текущим выводом больше значения
interval, переданного в конструктор - то происходит вывод значения. Иначе - не
происходит, и сообщение отбрасывается. То есть класс ограничивает частоту вывода в
консоль. Другими словами, сообщение не будет выводится чаще чем 1 раз в interval
милисекунд. Реализовать описанный класс.

```
public class RateLimitedPrinter {
public RateLimitedPrinter(int interval) {
// code here
}
public void print(String message) {
// code here
}
}

```

Пример использования. Задается вывод не чаще 1 раза в секунду, далее
запускается цикл.

```
public static void main(String[] args) {
RateLimitedPrinter rateLimitedPrinter = new RateLimitedPrinter(1000);
for (int i = 0; i < 1_000_000_000; i++) {
rateLimitedPrinter.print(String.valueOf(i));
}
long currentTime = System.currentTimeMillis(); // возвращает текущее
// время
}

```

## Snils Validator ##

Номер СНИЛС состоит из 11 цифра, и валидация номера СНИЛС выполняется по
следующим правилам: (Валидация и проверка контрольного числа СНИЛС)

![image](https://user-images.githubusercontent.com/127130876/224950869-49f11a1b-f605-4d06-9cac-20148e37a374.png)

Реализовать интерфейс SnilsValidator


```
public interface SnilsValidator {
/**
* Проверяет, что в строке содержится валидный номер СНИЛС
* @param snils снилс
* @return результат проверки
*/
boolean validate(String snils);
}

```

Который возвращает true если номер СНИЛС валидный, false - в противном случае.
Можно считать, что номер передается в виде строки, содержащей исключительно
цифры от 0 до 9.


```

int x = Character.digit(‘7’, 10);// конвертация символа в число. x == 7
boolean isDigit = Character.isDigit(‘7’); // true

```

Пример:

```

System.out.println(new SnilsValidatorImpl().validate("01468870570")); //false

System.out.println(new SnilsValidatorImpl().validate("90114404441")); //true

```

Обратить внимание, что переданная строка может быть произвольной. Метод должен
возвращать true тогда и только тогда, когда в строке валидный СНИЛС

## StatsAccumulator ##

Необходимо реализовать интерфейс StatsAccumulator


```

public interface StatsAccumulator {
/**
* Добавляет число в аккумулятор. Вызывается многократно
* @param value число
*/
void add(int value);
/**
* Возвращает минимальное из всех добавленных чисел
* @return минимальное из всех добавленных чисел
*/
int getMin();
/**
* Возвращает максимальное из всех добавленных чисел
* @return максимальное из всех добавленных чисел
*/
int getMax();
/**
* Возвращает количество всех добавленных чисел
* @return количество добавленных чисел
*/
int getCount();
/**
* Возвращает среднее арифметическое всех добавленных чисел
* @return среднее арифметическое всех добавленных
*/
Double getAvg();
}

```

Объект данного класса, будучи созданным, может принимать значения через метод
add. Приняв значение, объект меняет свое внутреннее состояние, чтобы в любой
момент времени предоставить данные о количестве переданных ему элементах,
минимальному их них, максимальному из них, а также о среднем арифметическом
всех переданных ему элементов

Пример использования

```

StatsAccumulator s = …; // как то создается
s.add(1);
s.add(2);
System.out.println(s.getAvg()); // 1.5 - среднее арифметическое
элементов
s.add(0);
System.out.println(s.getMin()); // 0 - минимальное из переданных
значений
s.add(3);
s.add(8);
System.out.println(s.getMax()); // 8 - максимальный из переданных
System.out.println(s.getCount()); // 5 - количество переданных элементов

```

Написать решение, использующее O(1) памяти. Другими словами - нельзя хранить все
переданные в метод add числа.
