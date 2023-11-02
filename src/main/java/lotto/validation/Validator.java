package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void validateThousandMultiple(int number){
        if((number%1000) != 0){
            throw new IllegalArgumentException("1000단위로 이루어진 숫자가 아닙니다.");
        }
    }

    public static void validateMoreThan1000(int number){
        if(number < 1000){
            throw new IllegalArgumentException("1000 이상의 숫자가 아닙니다.");
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(nonDuplicateNumbers.size() != 6){
            throw new IllegalArgumentException("번호들은 중복 될 수 없습니다.");
        }
    }

    public static void validateContainComma(String str){
        if(!str.contains(",")){
            throw new IllegalArgumentException("컴마가 들어있지 않습니다.");
        }
    }


}
