package lotto.domain;

import java.math.BigInteger;

public class PurchaseAmount {
    public static final String unit = "1000";
    private final BigInteger amount;

    public PurchaseAmount(BigInteger amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(BigInteger amount) {
        validateIsZero(amount);
        validateDivisible(amount);
    }

    private void validateIsZero(BigInteger amount) {
        if (amount.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원일 수 없습니다.");
        }
    }

    private void validateDivisible(BigInteger amount) {
        if (!amount.remainder(new BigInteger(unit)).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException(String.format("[ERROR] 구입 금액은 %d원으로 나누어 떨어져야 합니다.", unit));
        }
    }

    public BigInteger getQuantity() {
        return amount.divide(new BigInteger(unit));
    }

    public BigInteger getAmount() {
        return amount;
    }
}
