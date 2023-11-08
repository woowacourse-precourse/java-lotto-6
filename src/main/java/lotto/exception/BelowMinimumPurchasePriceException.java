package lotto.exception;

public class BelowMinimumPurchasePriceException extends InvalidPurchasePriceException {

    private static final String messageFormat = "최소 입력 금액은 1000원입니다. 현재 입력 금액 : %d";

    public BelowMinimumPurchasePriceException(long purchasePrice) {
        super(String.format(messageFormat, purchasePrice));
    }
}
