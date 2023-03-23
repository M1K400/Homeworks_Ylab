package Transliterator.repository;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransliteratorImpl implements Transliterator {


    @Override
    public String transliterate(String source) {

        StringBuilder sourceText = new StringBuilder(source);

        //Используем регулярные выражения
        Pattern pattern = Pattern.compile("[А-ЯЁ]+",Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(source);

        ArrayList<Character> letters = new ArrayList<>();

        while (matcher.find()){
            StringBuilder res = new StringBuilder(matcher.group());
            for (int i = 0; i < res.length();i++){

                String resMap = TransliteratorMap.getLiteralMap().get((res.charAt(i) + ""));

                if (!resMap.isEmpty()){
                    letters.add(resMap.charAt(0));
                }

            }
            sourceText.replace(matcher.start(),matcher.end(),letters.stream().map(val->val.toString()).reduce((acc,val)->acc + val).get());
            letters.clear();
        }
        return sourceText.toString();
    }


}
