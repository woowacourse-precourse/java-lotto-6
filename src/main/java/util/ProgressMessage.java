package util;

public enum ProgressMessage {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    OUTPUT_TICKET_COUNT("개를 구매했습니다."),
    INPUT_WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요.");

    private final String message;

    ProgressMessage(String message) {
        this.message = message;
    }

    public String getProgressMessage() {
        return message;
    }
}
