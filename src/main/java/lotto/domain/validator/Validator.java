package lotto.domain.validator;

import lotto.constant.PatternConstant;
import lotto.constant.RegularConstant;
import lotto.enums.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

public final class Validator {

    private Validator() {
    }

    public static void validateExistValue(String inputValue) {
        String val = inputValue.trim();
        if (val.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NON_EXISTENT_VALUE.getMessage());
        }
    }

    public static int validateNumericInput(String inputValue) {
        Matcher matcher = PatternConstant.NUMBER_PATTERN.matcher(inputValue);

        if(!matcher.matches()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMERIC_VALUE.getMessage());
        }

        return Integer.parseInt(inputValue);
    }

    public static int validateDivisibleBy1000(int inputMoney) {
        if (inputMoney % RegularConstant.UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INDIVISIBLE_BY_1000.getMessage());
        }

        return inputMoney / RegularConstant.UNIT_AMOUNT;
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        boolean hasDuplicates = false;
        Set<Integer> duplicateChecker = new HashSet<>();

        for (Integer number : numbers) {
            if (!duplicateChecker.add(number)) {
                hasDuplicates = true;
                break;
            }
        }

        if (hasDuplicates) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_HAS_DUPLICATE_NUMBERS.getMessage());
        }
    }
    
}
