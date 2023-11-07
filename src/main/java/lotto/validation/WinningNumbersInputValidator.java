package lotto.validation;

import static lotto.validation.constant.WinningNumbersInputConstant.CHECK_COMMA_MESSAGE;
import static lotto.validation.constant.WinningNumbersInputConstant.CHECK_SPLIT_COUNT;
import static lotto.validation.constant.WinningNumbersInputConstant.COUNT_NUMBERS;
import static lotto.validation.constant.WinningNumbersInputConstant.DUPLICATE_MESSAGE;
import static lotto.validation.constant.WinningNumbersInputConstant.NUMBERS_COUNT_MESSAGE;
import static lotto.validation.constant.CommonErrorConstant.LOTTO_MAX_NUMBER;
import static lotto.validation.constant.CommonErrorConstant.LOTTO_MIN_NUMBER;
import static lotto.validation.constant.CommonErrorConstant.NUMBER_RANGE_MESSAGE;
import static lotto.validation.constant.CommonErrorConstant.SPLIT_MESSAGE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersInputValidator {

    public void validateNumberRange(String input) {
        List<String> numbers = stringToCollection(input);
        numbers.forEach(number -> isValidNumberRange(Integer.parseInt(number)));
    }

    private void isValidNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER.getNumber() || number > LOTTO_MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    public void validateCommaSeparatedNumbers(String input) {
        if (hasNotCommaSeparatedNumbers(input)) {
            throw new IllegalArgumentException(CHECK_COMMA_MESSAGE.getMessage());
        }
    }

    private boolean hasNotCommaSeparatedNumbers(String input) {
        String[] numbers = input.split(SPLIT_MESSAGE.getMessage());
        return numbers.length < CHECK_SPLIT_COUNT.getNumber();
    }

    public void validateNumberDuplication(String input) {
        List<String> numbers = stringToCollection(input);
        Set<String> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE.getMessage());
        }
    }

    private List<String> stringToCollection(String input) {
        return Arrays.asList(input.split(SPLIT_MESSAGE.getMessage()));
    }

    public void validateNumbersCount(String input) {
        if (hasNotValidNumbersCount(input)) {
            throw new IllegalArgumentException(NUMBERS_COUNT_MESSAGE.getMessage());
        }
    }

    private boolean hasNotValidNumbersCount(String input) {
        String[] numbers = input.split(SPLIT_MESSAGE.getMessage());
        return numbers.length != COUNT_NUMBERS.getNumber();
    }

    public void validateInputNumbersNumericFormat(String input) {
        List<String> numbers = stringToCollection(input);
        numbers.forEach(CommonErrorValidator::validateInputNumericFormat);
    }

    public void validateWinningNumbers(String input) {
        validateInputNumbersNumericFormat(input);
        validateNumberRange(input);
        validateCommaSeparatedNumbers(input);
        validateNumberDuplication(input);
        validateNumbersCount(input);
    }
}
