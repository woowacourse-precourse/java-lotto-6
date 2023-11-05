package lotto.validation;

import static lotto.validation.enumType.WinningNumbers.LOTTO_MAX_NUMBER;
import static lotto.validation.enumType.WinningNumbers.LOTTO_MIN_NUMBER;
import static lotto.validation.enumType.WinningNumbers.NUMBER_RANGE_MESSAGE;
import static lotto.validation.enumType.WinningNumbers.SPLIT_MESSAGE;

public class WinningNumbersValidator {

    public void validateNumberRange(String input) {
        String[] numbers = input.split(SPLIT_MESSAGE.getMessage());
        for (String value : numbers) {
            int number = Integer.parseInt(value);
            isValidNumberRange(number);
        }
    }

    private void isValidNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER.getNumber() || number > LOTTO_MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
