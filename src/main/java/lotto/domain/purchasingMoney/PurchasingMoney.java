package lotto.domain.purchasingMoney;

public record PurchasingMoney(int amount) {

    public PurchasingMoney {
        validateUnit(amount);
        validateIsPositive(amount);
        validateMaxPurchaseAmountLimit(amount);
    }

    private void validateUnit(int amount) {
        int cashUnit = PurchasingMoneyConfig.CASH_UNIT.getValue();
        int remainder = amount % cashUnit;
        int zero = 0;
        if (remainder > zero) {
            throw new IllegalArgumentException(PurchasingMoneyExceptionMessages.INVALID_CASH_UNIT.getMessage());
        }
    }

    private void validateIsPositive(int amount) {
        int zero = 0;
        if (amount <= zero) {
            throw new IllegalArgumentException(PurchasingMoneyExceptionMessages.NEGATIVE_OR_ZERO.getMessage());
        }
    }

    public void validateMaxPurchaseAmountLimit(int amount) {
        if (amount > PurchasingMoneyConfig.LOTTO_PURCHASE_LIMIT.getValue()) {
            throw new IllegalArgumentException(PurchasingMoneyExceptionMessages.LOTTO_PURCHASE_OVER_LIMIT.getMessage());
        }
    }

    public int countPurchasableAmount() {
        return amount / PurchasingMoneyConfig.LOTTO_PRICE.getValue();
    }

}
