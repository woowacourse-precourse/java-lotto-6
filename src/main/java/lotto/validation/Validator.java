package lotto.validation;

public class Validator {

    public static void validateInt(String str){
        if(str.contains(".")){
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
    }

    public static void validateOnlyNumber(String str){
        if(!str.matches("[0-9]+")){
            throw new IllegalArgumentException("숫자로만 이루어진 문자가 아닙니다.");
        }
    }
}
