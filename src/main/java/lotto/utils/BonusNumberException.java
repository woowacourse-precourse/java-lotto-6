package lotto.utils;

import java.util.List;

import static lotto.utils.ExceptionMessage.*;

public class BonusNumberException {

    public void outsideRange(String input) {
        String[] inputData = input.split(",");
        int numberValue;

        for(String value : inputData) {
            numberValue = Integer.parseInt(value);
            if (numberValue > 45 || numberValue < 0) {
                throw new IllegalArgumentException(OUTSIDE_RANGE.getMessage());
            }
        }
    }

    public void duplicateNumber(List<String> winningNumbers, String input) {
        for (String number : winningNumbers) {
            if (number.equals(input)) {
                throw new IllegalArgumentException(DUPLICATE_INPUT.getMessage());
            }
        }
    }

    public void notNumeric(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }
}
