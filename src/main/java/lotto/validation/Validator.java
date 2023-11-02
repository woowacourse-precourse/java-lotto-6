package lotto.validation;

public class Validator {

    public static void validateInt(String str){
        if(str.contains(".")){
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
    }

}
