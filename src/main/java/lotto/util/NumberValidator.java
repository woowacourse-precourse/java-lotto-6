package lotto.util;

import java.util.*;

import static lotto.constant.view.ErrorMessage.*;
import static lotto.constant.LottoNumberComposition.*;

public class NumberValidator {
    public String[] validateWinningNumber(String input) {
        String[] winningNumbers = input.split(",");
        validateChar(winningNumbers);
        validateEnterCount(winningNumbers);
        validateBlank(winningNumbers);
        validateDuplicate(winningNumbers);
        validateWinningRange(winningNumbers);
        validateComma(winningNumbers);

        return winningNumbers;
    }

    private void validateEnterCount(String[] inputNums) {
        if (inputNums.length != ENTER_COUNT.getNumber()) {
            throw new IllegalArgumentException(WINNING_COUNT.getMessage());
        }
    }

    private void validateBlank(String[] inputNums) {
        boolean result = Arrays.stream(inputNums)
                .noneMatch(str -> str.equals(" ") || str.equals(""));

        if (!result) {
            throw new IllegalArgumentException(NOT_BLANK.getMessage());
        }
    }

    private void validateDuplicate(String[] inputNums) {
        if (Arrays.stream(inputNums).distinct().count() != ENTER_COUNT.getNumber()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateWinningRange(String[] inputNums) {
        boolean result = Arrays.stream(inputNums)
                .mapToInt(Integer::parseInt)
                .noneMatch(this::isNotCorrectRange);
            if (!result) {
                throw new IllegalArgumentException(NUMBER_RANGE.getMessage());
        }
    }

    private void validateChar(String[] inputNums) {
        List<Integer> numbers = new ArrayList<>();
        for (String inputNum : inputNums) {
            int number = Integer.parseInt(inputNum);
            numbers.add(number);
        }

        for (Integer number : numbers) {
            if (number < START_NUMBER.getNumber() || number > END_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ENTER_NUMBER.getMessage());
            }
        }
    }

    private void validateComma(String[] inputNums) {
        String combined = String.join(",", inputNums);
        String[] splitNumbers = combined.split(",");

        if(splitNumbers.length != ENTER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ENTER_COMMA.getMessage());
        }
    }


    private boolean isNotCorrectRange(int number) {
        return number < START_NUMBER.getNumber() || number > END_NUMBER.getNumber();
    }
}
