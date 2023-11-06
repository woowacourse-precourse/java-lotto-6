package lotto.model;

import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumber(String numbers) {
        List<String> splitNumbers = deleteBlankAndSplit(numbers);
        validateWinningNumbers(splitNumbers);
        this.winningNumbers = splitNumbers.stream().map(Integer::parseInt).toList();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<String> deleteBlankAndSplit(String numbers) {
        return new ArrayList<>(List.of(numbers.replaceAll(" ", "").split(",")));
    }

    private void validateWinningNumbers(List<String> numbers) {
        if (areAllDigits(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIGIT);
        }

        if (areEmptyOrBlank(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EMPTY_OR_BLANK);
        }

        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DUPLICATE);
        }

        List<Integer> toIntList = numbers.stream().map(Integer::parseInt).toList();

        if (isZeroOrMinus(toIntList)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_MINUS_OR_ZERO);
        }
    }

    private void validateBonusNumber(String bonus) {
        if (!isDigit(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIGIT);
        }

        if (isEmptyOrBlank(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EMPTY_OR_BLANK);
        }

        if (isDuplicatedWinningNumber(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DUPLICATE);
        }

        if (isZeroOrMinus(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_MINUS_OR_ZERO);
        }
    }

    public boolean areAllDigits(List<String> numbers) {
        return numbers.stream().allMatch(this::isDigit);
    }

    private boolean isDigit(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private boolean areEmptyOrBlank(List<String> numbers) {
        return numbers.stream().anyMatch(String::isEmpty);
    }

    private boolean isEmptyOrBlank(String bonus) {
        return bonus.isEmpty() || bonus.isBlank();
    }

    private boolean isDuplicated(List<String> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean isDuplicatedWinningNumber(String bonus) {
        int number = Integer.parseInt(bonus);
        return winningNumbers.stream().anyMatch(winningNumber -> winningNumber == number);
    }

    private boolean isZeroOrMinus(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number <= 0);
    }

    private boolean isZeroOrMinus(String bonus) {
        return Integer.parseInt(bonus) <= 0;
    }
}
