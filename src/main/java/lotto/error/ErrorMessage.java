package lotto.error;

public final class ErrorMessage {

    private ErrorMessage() {
        throw new UnsupportedOperationException();
    }

    public static final String INVALID_PURCHASE_AMOUNT_FORMAT = "구입 금액이 정수 형태가 아닙니다";
}
