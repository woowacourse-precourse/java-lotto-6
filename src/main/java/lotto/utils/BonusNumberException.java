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
                throw new IllegalArgumentException(String.valueOf(OUTSIDE_RANGE));
            }
        }
    }

    public void duplicateNumber(List<String> winningNumbers, String input) {
        for (String number : winningNumbers) {
            if (number.equals(input)) {
                throw new IllegalArgumentException(String.valueOf(DUPLICATE_INPUT));
            }
        }
    }

    public void notNumeric(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.valueOf(NOT_NUMBER));
        }
    }
}
