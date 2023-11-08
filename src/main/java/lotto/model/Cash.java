package lotto.model;


import lotto.util.ErrorCode;

public class Cash {
    private final int UNIT = 1000;
    private static int amount = 0;
    public Cash(int amount) {
        validateAmount(amount);
        validateAmountUnit(amount);
        Cash.amount = amount;
    }

    public int getCount() {
        return amount / UNIT;
    }

    public static int getAmount() { return amount; }

    private void validateAmount(int amount) {
        if(amount < UNIT) {
            throw new IllegalArgumentException(ErrorCode.INVALID_CASH_AMOUNT.getMessage());
        }
    }

    private void validateAmountUnit(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_CASH_UNIT.getMessage());
        }
    }
}