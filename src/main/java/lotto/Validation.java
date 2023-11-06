package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constant.*;

public class Validation {
    public static void validateMoney(String input) throws IllegalArgumentException{
        int money = validateInteger(input);
        validateDivideBy1000(money);
    }
    private static int validateInteger(String input){
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_NUMBER_EXCEPTION_MSG);
        }
    }

    private static void validateDivideBy1000(int money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException(INPUT_NOT_DIVIDE_EXCEPTION_MSG);
        }
    }

    public static List<Integer> validateWinningNumber(String input) throws IllegalArgumentException{
        List<String> splittedInput = validateDivision(input);
        validateNumberCount(splittedInput);
        return validateIntegers(splittedInput);
    }

    private static List<String> validateDivision(String input){
        if (!input.contains(",")){
            throw new IllegalArgumentException(INPUT_DIVISION_EXCEPTION_MSG);
        }
        List<String> splittedInput = new ArrayList<>();
        splittedInput.addAll(Arrays.asList(input.split(",")));
        return splittedInput;
    }

    private static void validateNumberCount(List<String> input){
        if (input.size() != 6){
            throw new IllegalArgumentException(INPUT_WINNING_NUMBER_COUNT_EXCEPTION_MSG);
        }
    }

    private static List<Integer> validateIntegers(List<String> input){
        try {
            List<Integer> winningNumber = input.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_NUMBER_EXCEPTION_MSG);
        }
        return null;
    }
}
