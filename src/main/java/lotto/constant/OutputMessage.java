package lotto.constant;

public enum OutputMessage {
    OUTPUT_PURCHASE_AMOUNT_MESSAGE("개를 구매했습니다.");

    private final String Message;

    OutputMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
