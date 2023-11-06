package lotto.domain.cash;

public record Cash(int amount) {

    public Cash {
        validateUnit(amount);
        validateIsPositive(amount);
    }

    private void validateUnit(int amount) {
        int cashUnit = CashConfig.CASH_UNIT.getValue();
        int remainder = amount % cashUnit;
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
