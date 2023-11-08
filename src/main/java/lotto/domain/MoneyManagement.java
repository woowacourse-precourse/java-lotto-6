package lotto.domain;

import lotto.exception.AmountMinimumException;
import lotto.exception.AmountUnitException;
import lotto.exception.InputMoneyNotDigitException;
import lotto.exception.InputMoneyOverflowException;

public class MoneyManagement {
    private final int balance;
    private static final int PERCENT = 100;
    private static final int LOTTO_AMOUNT = 1000;
    private static final int ZERO = 0;
    private static final String NUMERIC_PATTERN = "\\d+";
    private static final String ERROR_HEAD = "[ERROR] ";

    private MoneyManagement(final String userInput) {
        validate(userInput);
        balance = toInt(userInput);
    }

    public static MoneyManagement from(final String userInput) {
        return new MoneyManagement(userInput);
    }

    private void validate(final String userInput) {
        validNumber(userInput);
        int userAmount = toInt(userInput);
        validAmountMinimum(userAmount);
        validLottoAmountUnit(userAmount);
    }

    private void validNumber(final String userInput) {
        if (!userInput.matches(NUMERIC_PATTERN)) {
            throw new InputMoneyNotDigitException();
        }
    }

    private int toInt(final String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new InputMoneyOverflowException();
        }
    }

    private void validAmountMinimum(final int userAmount) {
        if (userAmount < LOTTO_AMOUNT) {
            throw new AmountMinimumException();
        }
    }

    private void validLottoAmountUnit(final int userAmount) {
        if (userAmount % LOTTO_AMOUNT != ZERO) {
            throw new AmountUnitException();
        }
    }

    public static long totalAmount(final LottoResult lottoResult) {
        return lottoResult.getResults().entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();
    }

    public int getQuantity() {
        return balance / LOTTO_AMOUNT;
    }

    public int getBalance() {
        return balance;
    }

    public static double calculateYield(final int purchaseAmount, final long totalAmount) {
        double value = (double) totalAmount / (double) purchaseAmount * PERCENT;
        return Math.round(value);
    }
}
