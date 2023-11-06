package lotto.io.message;

public enum OutputMessage {

    LOTTO_PURCHASE_AMOUNT_MESSAGE("개를 구매했습니다.");

    public final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
