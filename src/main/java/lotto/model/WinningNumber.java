package lotto.model;

import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumber(String numbers) {
        List<String> splitNumbers = deleteBlankAndSplit(numbers);
        this.winningNumbers = validateWinningNumbers(splitNumbers);
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<String> deleteBlankAndSplit(String numbers) {
        return new ArrayList<>(List.of(numbers.replaceAll(" ", "").split(",")));
    }

    private List<Integer> validateWinningNumbers(List<String> numbers) {
        if (areAllDigits(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIGIT);
        }

        if (isEmptyOrBlank(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EMPTY_OR_BLANK);
        }

        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DUPLICATE);
        }

        List<Integer> toIntList = numbers.stream().map(Integer::parseInt).toList();

        if (isZeroOrMinus(toIntList)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_MINUS_OR_ZERO);
        }

        return toIntList;
    }

    public boolean areAllDigits(List<String> numbers) {
        return numbers.stream().allMatch(this::isDigit);
    }

    private boolean isDigit(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private boolean isEmptyOrBlank(List<String> numbers) {
        return numbers.stream().anyMatch(String::isEmpty);
    }

    private boolean isDuplicated(List<String> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean isZeroOrMinus(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number <= 0);
    }
}
