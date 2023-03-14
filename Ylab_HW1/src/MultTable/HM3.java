package MultTable;

/**
 *
 *
 * На вход ничего не подается, необходимо распечатать таблицу умножения чисел
 * от 1 до 9 (включая)
 * 
 * Пример:
 * Вывод:
 * 1 x 1 = 1
 * 1 x 2 = 2
 * …
 * <часть вывода пропущена>
 * …
 * 9 x 9 = 81
 *
 *
 */


public class HM3 {

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++ ){
            for (int j = 1; j <= 9; j++){
                System.out.println(i + " x " + j + " = " + (i * j));
            }
            System.out.println();
        }
    }
}
