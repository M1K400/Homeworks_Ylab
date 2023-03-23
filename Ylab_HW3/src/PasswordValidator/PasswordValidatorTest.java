package PasswordValidator;

import PasswordValidator.repository.PasswordValidatorImpl;

import java.util.Scanner;

public class PasswordValidatorTest {



    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Введи логин: ");
            String login = scanner.nextLine();
            System.out.print("Введи пароль: ");
            String password = scanner.nextLine();
            System.out.print("Введи ещё раз пароль чтобы проверить правильно ли он ведён: ");
            String confirmPassword = scanner.nextLine();
            System.out.println("Результат: "  + PasswordValidatorImpl.passwordValidator(login,password,confirmPassword));
        } catch (RuntimeException ex){
            System.out.println("Произошла ошибка при работе программы: "  + ex.getMessage());
        }
    }

}
