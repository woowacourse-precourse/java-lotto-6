package lotto.domain.cash;

public class Cash {

    private final int amount;

    public Cash(int amount) {
        validateUnit(amount);
        validateIsPositive(amount);
        this.amount = amount;
    }

    private void validateUnit(int amount) {
        int cashUnit = CashConfig.CASH_UNIT.getValue();
        int remainder =  amount % cashUnit;
        int zero = 0;
        if (remainder > zero) {
            throw new IllegalArgumentException(CashExceptionMessages.INVALID_CASH_UNIT.getMessage());
        }
    }

    private void validateIsPositive(int amount) {
        int zero = 0;
        if (amount <= zero) {
            throw new IllegalArgumentException(CashExceptionMessages.NEGATIVE_OR_ZERO.getMessage());
        }
    }

}
