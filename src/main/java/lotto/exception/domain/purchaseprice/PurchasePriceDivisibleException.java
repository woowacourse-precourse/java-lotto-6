package lotto.exception.domain.purchaseprice;

public class PurchasePriceDivisibleException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구매 금액은 1,000원 단위여야 합니다.";

    public PurchasePriceDivisibleException() {
        super(ERROR_MESSAGE);
    }
}
