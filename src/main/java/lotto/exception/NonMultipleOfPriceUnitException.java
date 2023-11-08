package lotto.exception;

public class NonMultipleOfPriceUnitException extends InvalidPurchasePriceException {

    private static final String messageFormat = "구매 금액은 1000원 단위로 입력되어야 합니다. 현재 입력 금액 : %d";

    public NonMultipleOfPriceUnitException(long purchasePrice) {
        super(String.format(messageFormat, purchasePrice));
    }
}
