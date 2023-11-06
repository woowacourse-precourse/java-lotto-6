package lotto.utils;

import java.util.Arrays;
import java.util.List;

import static lotto.constValue.ConstMessage.*;

public class Validator {
    public static void validateNullOrEmpty(String input) {
        if (input == null){
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    public static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateIsNumbers(String[] inputs){
        for(String input: inputs){
            validateIsNumber(input);
        }
    }

    public static void validateIsNumberInRange(int winningNumber){
        if ( !(winningNumber >= 1 && winningNumber <= 45) ){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateIsNumbersInRange(List<Integer> winningNumbers){
        for (int winningNumber : winningNumbers){
            validateIsNumberInRange(winningNumber);
        }
    }

    public static void hasDuplicateInNumbers(List<Integer> winningNumbers){
        boolean hasDuplicate = winningNumbers.stream()
                .distinct()
                .count() != winningNumbers.size();

        if ( hasDuplicate ) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
