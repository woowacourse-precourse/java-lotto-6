package lotto.model;

import lotto.exception.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

import static lotto.validator.Validator.validateCondition;

public class WinningNumber {

    private final Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumber(String numbers) {
        List<String> splitNumbers = deleteBlankAndSplit(numbers);
        validateWinningNumbers(splitNumbers);
        this.winningNumbers = new Lotto(splitNumbers.stream().map(Integer::parseInt).toList());
    }

    public Lotto getWinningNumbers() {
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
        validateCondition(areEmptyOrBlank(numbers), ExceptionMessage.NOT_EMPTY_OR_BLANK);
        validateCondition(!areAllDigits(numbers), ExceptionMessage.IS_NOT_DIGIT);
    }

    private void validateBonusNumber(String bonus) {
        validateCondition(isEmptyOrBlank(bonus), ExceptionMessage.NOT_EMPTY_OR_BLANK);
        validateCondition(!isDigit(bonus), ExceptionMessage.IS_NOT_DIGIT);
        validateCondition(isDuplicatedWinningNumber(bonus), ExceptionMessage.NOT_DUPLICATE);
        validateCondition(isZeroOrMinus(bonus), ExceptionMessage.NOT_MINUS_OR_ZERO);
    }

    public boolean areAllDigits(List<String> numbers) {
        return numbers.stream().allMatch(this::isDigit);
    }

    private boolean isDigit(String str) {
        return str.matches("-?\\d+");
    }

    private boolean areEmptyOrBlank(List<String> numbers) {
        return numbers.stream().anyMatch(String::isEmpty);
    }

    private boolean isEmptyOrBlank(String bonus) {
        return bonus.isEmpty() || bonus.isBlank();
    }

    private boolean isDuplicatedWinningNumber(String bonus) {
        int number = Integer.parseInt(bonus);
        return winningNumbers.getNumbers().stream()
                .anyMatch(winningNumber -> winningNumber == number);
    }

    private boolean isZeroOrMinus(String bonus) {
        return Integer.parseInt(bonus) <= 0;
    }
}
