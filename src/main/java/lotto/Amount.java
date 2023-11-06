package lotto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Amount extends BigInteger {
    public static final Amount DEFAULT_PURCHASE_AMOUNT = new Amount("1000");
    private static final int ZERO = 0;
    private static final BigDecimal HUNDRED = new BigDecimal(100);
    private static final int SCALE_TWO = 2;

    public Amount(String val) {
        super(val);
    }

    public static double calculateReturnRate(Amount purchaseAmount, Amount totalPrizeMoney) {
        BigDecimal buyingPrice = new BigDecimal(purchaseAmount);
        BigDecimal totalProfit = new BigDecimal(totalPrizeMoney);

        BigDecimal multiplied = totalProfit.multiply(HUNDRED);
        BigDecimal returnRate = multiplied.divide(buyingPrice, SCALE_TWO, RoundingMode.HALF_UP);
        return returnRate.doubleValue();
    }

    public boolean lessThan(Amount amount) {
        return this.compareTo(amount) < ZERO;
    }

    public boolean isMultipleOf(Amount amount) {
        BigInteger modded = this.mod(amount);
        return modded.compareTo(BigInteger.ZERO) == ZERO;
    }

    public Amount add(Amount val) {
        BigInteger addedVal = this.add((BigInteger) val);
        String amount = addedVal.toString();
        return new Amount(amount);
    }
}
