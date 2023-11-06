package lotto.domain;

import static java.lang.String.format;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoSetting.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<String> numbersInput) {
        this.numbers = validateWinningNumber(numbersInput);
    }

    private List<Integer> validateWinningNumber(List<String> numbersInput) {
        validateSize(numbersInput);
        validateDuplicate(numbersInput);
        List<Integer> winningNumbers = convertInteger(numbersInput);
        validateRange(winningNumbers);
        return winningNumbers;
    }

    private void validateRange(List<Integer> numbers) {
        boolean isInvalidRange = numbers
                .stream()
                .anyMatch(number -> number < MIN_RANDOM_NUMBER.getValue() || number > MAX_RANDOM_NUMBER.getValue());

        if (isInvalidRange) {
            throw new IllegalArgumentException(
                    format(NOT_RANGE.getMessage(), MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue())
            );
        }
    }

    private List<Integer> convertInteger(List<String> numbersInput) {
        return numbersInput.stream()
                .map(this::validateNumeric)
                .toList();
    }

    private Integer validateNumeric(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }

    private void validateDuplicate(List<String> numbersInput) {
        Set<String> uniqueNumbers = new HashSet<>(numbersInput);
        if (uniqueNumbers.size() != numbersInput.size()) {
            throw new IllegalArgumentException(NOT_UNIQUE.getMessage());
        }
    }

    private void validateSize(List<String> numbersInput) {
        if (numbersInput.size() != 6) {
            throw new IllegalArgumentException(NOT_LENGTH.getMessage());
        }
    }

    public void checkDuplicateBonus(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NOT_UNIQUE.getMessage());
        }
    }

    public int countWin(Lotto lotto) {
        return lotto.countWin(numbers);
    }
}
