package lotto.view;

import lotto.utils.ErrorMessage;

public class InputView {
    private final String DELIMITER = ",";

    public long validateCustomerMoneyInput(final String moneyInput) {
        if (moneyInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY.errorMessage);
        }

        moneyInput.chars().forEach(o -> {
            if (!Character.isDigit(o)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT_MONEY.errorMessage);
            }
        });

        return Long.parseLong(moneyInput);
    }

    public String[] validateWinningNumberInput(final String winningNumberInput) {
        if (winningNumberInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY.errorMessage);
        }
        if (!winningNumberInput.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER.errorMessage);
        }

        String[] splitByDelimiter = this.validateEachWinningNumberInput(winningNumberInput);

        return splitByDelimiter;
    }

    public String[] validateEachWinningNumberInput(final String winningNumberInput) {
        String[] splitByDelimiter = winningNumberInput.split(DELIMITER);

        for (String eachWinningNumber : splitByDelimiter) {
            if (eachWinningNumber.chars().anyMatch(c -> !Character.isDigit((char) c))) {
                throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT_WINNING_NUM.errorMessage);
            }
        }

        return splitByDelimiter;
    }

    public int validateBonusNumberInput(final String bonusNumberInput) {
        if (bonusNumberInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY.errorMessage);
        }
        if (bonusNumberInput.chars().anyMatch(c -> !Character.isDigit((char) c))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT_BONUS_NUM.errorMessage);
        }

        int bonusNumber = Integer.parseInt(bonusNumberInput);

        return bonusNumber;
    }
}
