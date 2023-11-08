package lotto.exception;

public class InvalidPurchasePriceFormatException extends InvalidPurchasePriceException {

    private static final String messageFormat = "%s는 정수 타입으로 올바르게 변환될 수 없습니다.";

    public InvalidPurchasePriceFormatException(String purchasePrice) {
        super(String.format(messageFormat, purchasePrice));
    }
}
