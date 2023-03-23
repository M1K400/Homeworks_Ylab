package PasswordValidator.repository;

import PasswordValidator.exceptions.WrongLoginException;
import PasswordValidator.exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidatorImpl  {


    private static boolean checkLoginOrPass(String val){
        Pattern pattern = Pattern.compile("^[a-zA-Z\\d_]{1,20}$");
        Matcher matcher = pattern.matcher(val);
        return matcher.matches();

    }

    public static boolean passwordValidator(String login,String password, String confirmPassword){
        try {
            if (!checkLoginOrPass(login)){
                throw new WrongLoginException("Логин содержит недопустимые символы или логин слишком длинный ");
            }
            if (!checkLoginOrPass(password) ){
                throw new WrongPasswordException("Пароль содержит недопустимые символы или пароль слишком длинный ");
            }
            if (!password.equals(confirmPassword)){
                throw new WrongPasswordException("Пароль и подтверждение данного пароля не совпадают ");
            }

            return true;

        } catch (WrongPasswordException | WrongLoginException ex){
            System.out.println("Ошибка при проверке логина и пароля: " + ex.getMessage() );
            return false;
        }
    }






}
