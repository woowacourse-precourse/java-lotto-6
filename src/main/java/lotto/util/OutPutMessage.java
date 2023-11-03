package lotto.util;

public enum OutPutMessage {
    OUTPUT_MONEY_MESSAGE("개를 구매했습니다.");

    private final String message;

    OutPutMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
