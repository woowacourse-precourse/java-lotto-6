package lotto.util;

import java.util.List;
import java.util.Set;

public class ValidateNumber {

    public static int isPositiveInteger(String inputValue) {

        int inputNumber = isInteger(inputValue);
        isPositive(inputNumber);

        return inputNumber;
    }

    private static int isInteger(String inputValue) {

        if (!inputValue.matches("-?\\d+")){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }

        return Integer.parseInt(inputValue);
    }


    private static void isPositive(int inputValue){

        if(inputValue <= 0){
            throw new IllegalArgumentException("[ERROR] 0보다 큰 정수를 입력해주세요.");
        }

    }

    public static void isDuplicate(List<Integer> NumberList) {

        Set<Integer> set = Set.copyOf(NumberList);

        if(set.size() != NumberList.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }

    }

}
