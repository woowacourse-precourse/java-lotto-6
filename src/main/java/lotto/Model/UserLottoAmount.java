package lotto.Model;

import lotto.View.ExceptionMessage;

public class UserLottoAmount {
    private static final int LOTTO_PRICE = 1000;
    private int amount;

    public UserLottoAmount(String amountString) {
        int amountNum = validateAndParse(amountString);
        ValidateAmount(amountNum);
        this.amount = amountNum;
    }

    public int getAmount() {
        return amount;
    }

    private int validateAndParse(String amountString) {
        try {
            int parsedAmount = Integer.parseInt(amountString);
            if (parsedAmount <= 0) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER_ERROR);

            }
            if (parsedAmount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_NUMBER_ERROR);
            }
            return parsedAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR);
        }
    }

    public int CalcLottoCount() {
        return amount / LOTTO_PRICE;
    }

    private void ValidateAmount(int amount) {
        validateNatural(amount);
        validateDivisible(amount);
    }

    private void validateNatural(int amount) {
        if (amount <= 0) {
            ExceptionMessage.naturalException();
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            ExceptionMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }
}
