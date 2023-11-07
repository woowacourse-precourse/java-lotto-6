package util;

public enum ProgressMessage {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    OUTPUT_BUY_NUMBER("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String message;

    ProgressMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
