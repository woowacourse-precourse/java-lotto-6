package lotto.domain;


import static lotto.exception.ErrorType.AmountMinimumException;
import static lotto.exception.ErrorType.AmountUnitException;
import static lotto.exception.ErrorType.InputMoneyNotDigitException;
import static lotto.exception.ErrorType.InputMoneyOverflowException;

import lotto.exception.LottoException;

public class MoneyManagement {
    private static final int PERCENT = 100;
    private static final int LOTTO_AMOUNT = 1000;
    private static final int ZERO = 0;
    private static final String NUMERIC_PATTERN = "\\d+";
    private final int balance;

    private MoneyManagement(final String userInput) {
        validate(userInput);
        balance = toInt(userInput);
    }

    public static MoneyManagement from(final String userInput) {
        return new MoneyManagement(userInput);
    }

    public static long totalAmount(final LottoResult lottoResult) {
        return lottoResult.getResults().entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();
    }

    public static double calculateYield(final int purchaseAmount, final long totalAmount) {
        double value = (double) totalAmount / (double) purchaseAmount * PERCENT;
        return Math.round(value);
    }

    private void validate(final String userInput) {
        validNumber(userInput);
        int userAmount = toInt(userInput);
        validAmountMinimum(userAmount);
        validLottoAmountUnit(userAmount);
    }

    private void validNumber(final String userInput) {
        if (!userInput.matches(NUMERIC_PATTERN)) {
            throw new LottoException(InputMoneyNotDigitException);
        }
    }

    private int toInt(final String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new LottoException(InputMoneyOverflowException);
        }
    }

    private void validAmountMinimum(final int userAmount) {
        if (userAmount < LOTTO_AMOUNT) {
            throw new LottoException(AmountMinimumException);
        }
    }

    private void validLottoAmountUnit(final int userAmount) {
        if (userAmount % LOTTO_AMOUNT != ZERO) {
            throw new LottoException(AmountUnitException);
        }
    }

    public int getQuantity() {
        return balance / LOTTO_AMOUNT;
    }

    public int getBalance() {
        return balance;
    }
}
