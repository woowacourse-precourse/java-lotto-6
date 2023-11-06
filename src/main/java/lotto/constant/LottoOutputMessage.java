package lotto.constant;

public enum LottoOutputMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_RESULT("당첨 통계\n" + "---"),
    RANK_RESULT("%d개 일치"),
    BONUS_RESULT(", 보너스 볼 일치"),
    COUNT_RESULT(" (%s원) - %d개");

    private final String message;

    LottoOutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
