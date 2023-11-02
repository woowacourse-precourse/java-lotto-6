package lotto.exception.domain.purchaseprice;

public class PurchasePriceFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구매 금액은 숫자와 ,외에 다른 문자를 입력할 수 없습니다.";

    public PurchasePriceFormatException() {
        super(ERROR_MESSAGE);
    }
}
