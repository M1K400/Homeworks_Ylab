package Sequences.repository;


public class SequenceGeneratorImpl implements SequenceGenerator {

    /**
     * Выводит в консоль n первых членов последовательности A
     * @param n число членов последовательности для вывода
     */
    @Override
    public void a(int n) {
        System.out.print("A: \t");
        for (int i = 1; i <= n; i++ ){
            System.out.print((i * 2) + "\t");
        }
        System.out.println("\n");
    }


    /**
     * Выводит в консоль n первых членов последовательности B
     * @param n число членов последовательности для вывода
     */
    @Override
    public void b(int n) {
        System.out.print("B: \t");
        int res = 1;
        for (int i = 1; i <= n; i++ ){
            System.out.print(res  + "\t");
            res+=2;
        }
        System.out.println("\n");
    }

    /**
     * Выводит в консоль n первых членов последовательности C
     * @param n число членов последовательности для вывода
     */
    @Override
    public void c(int n) {
        System.out.print("C: \t");
        for (int i = 1; i <= n; i++){
            System.out.print((int)(Math.pow(i,2)) + "\t");
        }
        System.out.println("\n");
    }


    /**
     * Выводит в консоль n первых членов последовательности D
     * @param n число членов последовательности для вывода
     */
    @Override
    public void d(int n) {
        System.out.print("D: \t");
        for (int i = 1; i <= n; i++){
            System.out.print((int)(Math.pow(i,3)) + "\t");
        }
        System.out.println("\n");
    }


    /**
     * Выводит в консоль n первых членов последовательности E
     * @param n число членов последовательности для вывода
     */
    @Override
    public void e(int n) {
        System.out.print("E: \t");
        int res = -1;
        for (int i = 1; i <= n; i++){
            res*=-1;
            System.out.print(res+ "\t");
        }
        System.out.println("\n");
    }


    /**
     * Выводит в консоль n первых членов последовательности F
     * @param n число членов последовательности для вывода
     */
    @Override
    public void f(int n) {
        System.out.print("F: \t");
        int res = -1;
        for (int i = 1; i <= n; i++){
            res*=-1;
            System.out.print((i*res)+ "\t");
        }
        System.out.println("\n");
    }


    /**
     * Выводит в консоль n первых членов последовательности G
     * @param n число членов последовательности для вывода
     */
    @Override
    public void g(int n) {
        System.out.print("G: \t");
        int res = -1;
        for (int i = 1; i <= n; i++){
            res*=-1;
            System.out.print(((int)Math.pow(i,2)*res)+ "\t");
        }
        System.out.println("\n");
    }


    /**
     * Выводит в консоль n первых членов последовательности H
     * @param n число членов последовательности для вывода
     */
    @Override
    public void h(int n) {
        System.out.print("H: \t");
        int res = 1;
        for (int i = 1; i <= n;i++){
            if (i % 2 != 0){
                System.out.print(res+ "\t");
                res++;
            } else {
                System.out.print(0 + "\t");
            }
        }
        System.out.println("\n");
    }



    /**
     * Выводит в консоль n первых членов последовательности I
     * @param n число членов последовательности для вывода
     */
    @Override
    public void i(int n) {
        int res = 1;
        System.out.print("I: \t");
        for (int i = 1; i <= n; i++){
            System.out.print((res * i) + "\t");
            res = (res * i);
        }
        System.out.println("\n");
    }


    /**
     * Выводит в консоль n первых членов последовательности J
     * @param n число членов последовательности для вывода
     */
    @Override
    public void j(int n) {
        int[] mas = {0,0};
        System.out.print("J: \t");
        for (int i = 1; i <= n; i++){
            if (i == 0){
                System.out.print("1\t");
                mas[0] = 1;
            } else if (i == 1){
                System.out.print("1\t");
                mas[1] = 1;
            } else {
                int res = mas[0] + mas[1];
                System.out.print((res) + "\t");
                mas[0] = mas[1];
                mas[1] = res;
            }
        }
        System.out.println("\n");
    }



}
