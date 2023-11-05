package lotto;

import java.math.BigInteger;

public class Amount extends BigInteger {
    public static final Amount DEFAULT_PURCHASE_AMOUNT = new Amount("1000");

    public Amount(String val) {
        super(val);
    }

    public boolean lessThan(Amount amount) {
        return this.compareTo(amount) < 0;
    }

    public boolean isMultipleOf(Amount amount) {
        BigInteger modded = this.mod(amount);
        return modded.compareTo(Amount.ZERO) == 0;
    }
}
