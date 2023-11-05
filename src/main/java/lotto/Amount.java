package lotto;

import java.math.BigInteger;

public class Amount extends BigInteger {

    public Amount(String val) {
        super(val);
    }

    public boolean lessThan(Amount amount) {
        return this.compareTo(amount) == -1;
    }

    public boolean isMultipleOf(Amount amount) {
        BigInteger modded = this.mod(amount);
        return modded.compareTo(Amount.ZERO) == 0;
    }
}
