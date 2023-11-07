package lotto.utils;

import java.util.*;
import java.util.regex.Pattern;
public class Validator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private final static int MinimumAmount = 1000;
    private final static int MinimumRange = 1;
    private final static int MaximumRange = 45;

    private static Set<String> numberSet;

    public static boolean checkAmount(String amount){
        if(validateHasText(amount)){
            return true;
        }
        if(validateInteger(amount)){
            return true;
        }
        if(validateMinimum(amount)){
            return true;
        }
        if(validateDivided(amount)){
            return true;
        }
        return false;
    }

    public static boolean checkNumbers(String[] numbers){
        numberSet= new HashSet<>();
        if(validateNumberCount(numbers)){
            return true;
        }
        for(String number : numbers){
            if(checkNumber(number)){
                return true;
            }
            if(validateSameNumber(number)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkNumber(String number){
        if(validateHasText(number)){
            return true;
        }
        if(validateInteger(number)){
            return true;
        }
        if(validateRange(number)){
            return true;
        }
        return false;
    }

    private static boolean validateHasText(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 비어있습니다.");
        }
        return false;
    }

    private static boolean validateInteger(String input){
        if(!NUMERIC_PATTERN.matcher(input).matches()){
            throw new IllegalArgumentException("[ERROR] 정수가 아닙니다.");
        }
        return false;
    }


    private static boolean validateDivided(String input){
        if(Integer.parseInt(input) % 1000!=0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1000으로 나누어 떨어지지 않습니다.");
        }
        return false;
    }

    private static boolean validateMinimum(String input){
        if(Integer.parseInt(input) < MinimumAmount){
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1000원 입니다.");
        }
        return false;
    }

    private static boolean validateRange(String input){
        if(!isInRange(input)){
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1부터 45 까지 입니다.");
        }
        return false;
    }

    private static boolean isInRange(String input){
        if(Integer.parseInt(input)<MinimumRange || Integer.parseInt(input)>MaximumRange){
            return false;
        }
        return true;
    }

    private static boolean validateNumberCount(String[] numbers){
        if(Arrays.stream(numbers).count()!=6){
            throw new IllegalArgumentException("[ERROR] 로또 번호 갯수가 6개가 아닙니다.");
        }
        return false;
    }

    private static boolean validateSameNumber(String input){
        if(!numberSet.add(input)){
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }
        return false;
    }
}
