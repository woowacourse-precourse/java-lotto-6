package lotto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (money == 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 0원일 수 없습니다. 다시 입력하세요.");
        }
    }

    private void validateNotThousandUnit(final int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다. 다시 입력하세요.");
        }
    }

    private void validateNumbersSize(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수는 6개이어야 합니다. 다시 입력하세요.");
        }
    }

    private void validateDuplicateNumber(final List<Integer> winningNumbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (winningNumbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다. 다시 입력하세요.");
        }
    }

    private void validateNumbersBoundary(final List<Integer> winningNumbers) {
        winningNumbers.forEach(this::validateNumberBoundary);
    }

    private void validateBlankInput(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력은 공백이어선 안됩니다. 다시 입력하세요.");
        }
    }

    private void validateNumberFormat(final String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자이어야 합니다. 다시 입력하세요.");
        }
    }

    private void validateDuplicateBonusNumber(final List<Integer> winningNumbers, final int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력하세요.");
        }
    }

    private void validateNumberBoundary(final int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자입니다. 다시 입력하세요.");
        }
    }
}