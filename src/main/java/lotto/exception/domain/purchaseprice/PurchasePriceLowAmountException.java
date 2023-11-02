package lotto.exception.domain.purchaseprice;

public class PurchasePriceLowAmountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구매 금액은 1,000원 이상이어야 합니다.";

    public PurchasePriceLowAmountException() {
        super(ERROR_MESSAGE);
    }
}
