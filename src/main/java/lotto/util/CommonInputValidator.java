package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonInputValidator {
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;

    // Error message constant
    private static final String IS_NUMERIC_VALIDATOR_ERROR_MESSAGE = "[ERROR] 입력은 숫자 형태여야 합니다.";
    private static final String IS_IN_RANGE_VALIDATOR_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String IS_NOT_OVERLAP_SIX_VALIDATOR_ERROR_MESSAGE = "[ERROR] 6개의 숫자에 중복된 로또 번호가 존재합니다.";
    private static final String IS_NOT_OVERLAP_BONUS_VALIDATOR_ERROR_MESSAGE = "[ERROR] 보너스 번호와 중복된 로또 번호가 존재합니다.";

    public static void isNumericValidator(String number){
        try {
            Integer parsedNumber = Integer.parseInt(number);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(IS_NUMERIC_VALIDATOR_ERROR_MESSAGE);
        }
    }


    public static void isInRangeValidator(Integer number){
        if(number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER){
            throw new IllegalArgumentException(IS_IN_RANGE_VALIDATOR_ERROR_MESSAGE);
        }
    }
    public static void isNotOverlapSixValidator(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(Integer number : numbers){
            if(!uniqueNumbers.add(number)){
                throw new IllegalArgumentException(IS_NOT_OVERLAP_SIX_VALIDATOR_ERROR_MESSAGE);
            }
        }
    }

    public static void isNotOverlapBonusValidator(List<Integer> numbers, Integer bonusNumber){
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(IS_NOT_OVERLAP_BONUS_VALIDATOR_ERROR_MESSAGE);
        }
    }
}
