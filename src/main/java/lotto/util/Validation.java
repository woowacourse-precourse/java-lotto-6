package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.config.LottoConfig;
import lotto.config.ValidatorConfig;

public class Validation {

    private static final int ZERO = 0;
    private static final String COMMA = ",";

    public static void validateAmount(String input){
        validateInteger(input);
        validatePurchaseUnit(Integer.parseInt(input));
    }

    public static void validateLottoNumbers(List<Integer> input){
        validateDuplicate(input);
        validateListNumberInRange(input);
        validateLength(input);
    }

    private static void validatePurchaseUnit(int input){
        if(!(input % LottoConfig.LOTTO_LEAST_AMOUNT.getValue() == ZERO)){
            throw new IllegalArgumentException(ValidatorConfig.PURCHASE_UNIT_ERROR.getMessage());
        }
    }

    public static void validateInteger(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException(ValidatorConfig.STRING_TO_INTEGER_ERROR.getMessage());
        }
    }

    public static void validateListNumberInRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    public static void validateNumberInRange(int input) {
        if (input > LottoConfig.LOTTO_LAST_NUMBER.getValue() || input < LottoConfig.LOTTO_START_NUMBER.getValue()) {
            throw new IllegalArgumentException(ValidatorConfig.NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> input){
        Set<Integer> numbers = new HashSet<>(input);
        if(numbers.size() != input.size()){
            throw new IllegalArgumentException(ValidatorConfig.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private static void validateLength(List<Integer> input){
        if(input.size() != LottoConfig.LOTTO_LENGTH.getValue()){
            throw new IllegalArgumentException(ValidatorConfig.NUMBER_LENGTH_ERROR.getMessage());
        }
    }

}
