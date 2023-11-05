package lotto.utils;

import java.util.regex.Pattern;
public class Validator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private final static int Minimum = 1000;
    public boolean checkAmount(String amount){
        if(validateHasText(amount)){
            return true;
        }
        if(validateInteger(amount)){
            return true;
        }
        if(validateDivided(amount)){
            return true;
        }
        return false;
    }

    public boolean validateHasText(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 비어있습니다.");
        }
        return false;
    }

    public boolean validateInteger(String input){
        if(!NUMERIC_PATTERN.matcher(input).matches()){
            throw new IllegalArgumentException("[ERROR] 정수가 아닙니다.");
        }
        return false;
    }


    public boolean validateDivided(String input){
        if(Integer.parseInt(input) % 1000!=0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1000으로 나누어 떨어지지 않습니다.");
        }
        return false;
    }

    public boolean validateMinimum(String input){
        if(Integer.parseInt(input) >= Minimum){
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1000원 입니다.");
        }
        return false;
    }

}
