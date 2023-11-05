package lotto.constants;

public enum Message {
    NEW_LINE(System.lineSeparator()),
    ASK_PURCHASE("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT("%d개를 구매했습니다." + NEW_LINE.message),
    ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_HEADER("당첨 통계"),
    CONTOUR("---"),
    WINNING_RESULT("%d개 일치 (%s원) - %d개");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
