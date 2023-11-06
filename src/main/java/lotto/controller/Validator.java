package lotto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.Constants;
import lotto.utils.ErrorConstants;

public class Validator {
    public boolean validateMoneyInput(final String input) {
        try {
            validateBlankInput(input);
            validateNumberFormat(input);
            final int money = Integer.parseInt(input);
            validateZeroMoney(money);
            validateNotThousandUnit(money);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public boolean validateWinningNumbers(final List<Integer> numbers) {
        try {
            validateNumbersSize(numbers);
            validateNumbersBoundary(numbers);
            validateDuplicateNumber(numbers);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public boolean validateWinningBonusNumber(final List<Integer> winningNumbers, final String input) {
        try {
            validateBlankInput(input);
            validateNumberFormat(input);
            final int bonusNumber = Integer.parseInt(input);
            validateDuplicateBonusNumber(winningNumbers, bonusNumber);
            validateNumberBoundary(bonusNumber);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void validateZeroMoney(final int money) {
        if (money == Constants.ZERO_MONEY) {
            throw new IllegalArgumentException(ErrorConstants.ZERO_MONEY);
        }
    }

    private void validateNotThousandUnit(final int money) {
        if (money % Constants.DIVIDE_UNIT != Constants.MOD) {
            throw new IllegalArgumentException(ErrorConstants.THOUSAND_UNIT);
        }
    }

    private void validateNumbersSize(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorConstants.NUMBER_SIZE);
        }
    }

    private void validateDuplicateNumber(final List<Integer> winningNumbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorConstants.DUPLICATE_NUMBER);
        }
    }

    private void validateNumbersBoundary(final List<Integer> winningNumbers) {
        winningNumbers.forEach(this::validateNumberBoundary);
    }

    private void validateBlankInput(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_BLANK);
        }
    }

    private void validateNumberFormat(final String input) {
        if (!input.matches(Constants.BONUS_NUMBER_INPUT_REGEX)) {
            throw new IllegalArgumentException(ErrorConstants.NUMBER_FORMAT);
        }
    }

    private void validateDuplicateBonusNumber(final List<Integer> winningNumbers, final int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorConstants.DUPLICATE_NUMBER);
        }
    }

    private void validateNumberBoundary(final int bonusNumber) {
        if (bonusNumber < Constants.MIN_GENERATE_VALUE || bonusNumber > Constants.MAX_GENERATE_VALUE) {
            throw new IllegalArgumentException(ErrorConstants.NUMBER_BOUNDARY);
        }
    }
}