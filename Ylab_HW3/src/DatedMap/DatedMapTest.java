package DatedMap;

import DatedMap.repository.DatedMapImpl;

import java.util.Scanner;

public class DatedMapTest {

    private static final DatedMapImpl dateMap = new DatedMapImpl();


    public static void main(String[] args) {

        procces_work: {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Добро пожаловать !\nВыберите одно из действий\n");
                dateMap.put("Test","Hello");
                while (true){
                    System.out.println("Добавить ключ и значение - 1");
                    System.out.println("Найти запись по ключу - 2");
                    System.out.println("Узнать, существует ли запись - 3");
                    System.out.println("Удалить запись - 4");
                    System.out.println("Получить множество ключей - 5");
                    System.out.println("Получить дату добавления данной записи - 6");
                    System.out.println("Выйти из приложения - 0\n");
                    System.out.print("Номер команды: ");
                    int numberCommand = scanner.nextInt();
                    scanner.nextLine();
                    switch (numberCommand){
                        case 0: {break procces_work;}
                        case 1: {
                            System.out.print("Напишите ключ: ");
                            String keyEnter = scanner.nextLine();
                            System.out.print("Напишите значение: ");
                            String valueEnter = scanner.nextLine();
                            dateMap.put(keyEnter,valueEnter);
                          break;
                        }
                        case 2: {

                            System.out.print("Напишите ключ: ");
                            String keyEnter = scanner.nextLine();
                            System.out.println("Результат: " + dateMap.get(keyEnter));
                            break ;
                        }

                        case 3: {
                            System.out.print("Напишите ключ: ");
                            String keyEnter = scanner.nextLine();
                            System.out.println("Результат нахождения записи: " + dateMap.containsKey(keyEnter));
                            break;
                        }

                        case 4: {
                            System.out.print("Напишите ключ: ");
                            String keyEnter = scanner.nextLine();
                            dateMap.remove(keyEnter);
                            System.out.println("Запись вместе с ключом удалена !");
                            break;
                        }

                        case 5: {
                            System.out.println("Ключи: " + dateMap.keySet());
                            break;
                        }

                        case 6: {
                            System.out.print("Напишите ключ: ");
                            String keyEnter = scanner.nextLine();
                            System.out.println("Дата создания/обновления записи: " + dateMap.getKeyLastInsertionDate(keyEnter) );
                            break;
                        }
                    }
                    System.out.println();
                }
            } catch (RuntimeException ex){
                System.out.println("Произошла ошибка при работе программы: "  + ex.getMessage());
            }
        }


    }


}
