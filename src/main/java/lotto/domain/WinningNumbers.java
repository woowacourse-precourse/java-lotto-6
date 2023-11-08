package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.constants.DomainConstants.*;
import static lotto.domain.constants.ErrorMessageConstants.*;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<String> userInput) {
        validateWinningNumbers(userInput);
        this.winningNumbers = userInput.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public void validateDuplication(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUM_DUPLICATE_MESSAGE);
        }
    }

    public int countMatchedNumber(Lotto lotto) {
        return (int) lotto.getNumbers().stream().filter(winningNumbers::contains).distinct().count();
    }

    private void validateWinningNumbers(List<String> userInput) {
        validateNoBlank(userInput);
        validateOnlyNumbers(userInput);
        validateNumbersSizeSix(userInput);
        validateNumberRange(userInput);
        validateDuplicatedNumber(userInput);
    }

    private void validateNoBlank(List<String> userInput) {
        if (userInput.stream().anyMatch(num -> num.contains(BLANK))) {
            throw new IllegalArgumentException(NO_BLANK_MESSAGE);
        }
    }

    private void validateOnlyNumbers(List<String> userInput) {
        for (String num : userInput) {
            if(!(num.chars().allMatch(Character::isDigit))) {
                throw new IllegalArgumentException(ONLY_NUMBERS_MESSAGE);
            }
        }
    }

    private void validateNumbersSizeSix(List<String> userInput) {
        if (userInput.size() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException(SIX_NUMBERS_MESSAGE);
        }
    }

    private void validateNumberRange(List<String> userInput) {
        if (userInput.stream()
                .mapToInt(Integer::parseInt)
                .anyMatch(num -> num < LOTTO_MIN_NUM || num > LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(NUMBER_RANGE_MESSAGE);
        }
    }

    private void validateDuplicatedNumber(List<String> userInput) {
        if (userInput.size() != userInput.stream().distinct().count()) {
            throw new IllegalArgumentException(UNIQUE_SIX_NUMBERS_MESSAGE);
        }
    }
}