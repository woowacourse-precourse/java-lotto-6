package lotto.constants;

public enum ProgramMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    ProgramMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
