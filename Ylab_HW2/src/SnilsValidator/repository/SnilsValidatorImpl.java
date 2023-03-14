package SnilsValidator.repository;


public class SnilsValidatorImpl implements SnilsValidator{

    /**
     * Проверяет, что в строке содержится валидный номер СНИЛС
     * @param snils снилс
     * @return результат проверки
     */
    @Override
    public boolean validate(String snils) {
        int sum = 0;
        int val = 9;
        //Воспользуемся StringBuilder это лучше чем String по некоторым причинам.
        //Я решил так скажем воспользоваться регулярным выражением чтобы вытащить числа и соединить их с помощью метода join
        StringBuilder resJoin = new StringBuilder( String.join("",snils.split("[^\\d]")));
        //Если длина не равна 11 следовательно не стоит проверять данный снилс
        if (resJoin.length() != 11){
            return false;
        }
        int lastNumberCheck = Integer.parseInt(resJoin.substring(9,11));
        for (int i = 0; i < 9; i++){
            sum += (Integer.parseInt(resJoin.charAt(i) + "") * val);
            val--;
        }
        if (sum < 100){
            return sum == lastNumberCheck;
        } else if (sum == 100){
            return 0 == lastNumberCheck;
        } else {
            sum = sum % 101;
            if (sum == 100){
                return 0 == lastNumberCheck;
            } else {
                return sum == lastNumberCheck;
            }
        }
    }
}
