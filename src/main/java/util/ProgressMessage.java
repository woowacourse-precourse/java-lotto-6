package util;

public enum ProgressMessage {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    OUTPUT_TICKET_COUNT("개를 구매했습니다.");

    private final String message;

    ProgressMessage(String message) {
        this.message = message;
    }

    public String getProgressMessage() {
        return message;
    }
}
