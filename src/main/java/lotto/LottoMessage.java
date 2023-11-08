package lotto;

public enum LottoMessage {
    DELIMITER(","),
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_PURCHASE_QUANTITY("%d개를 구매했습니다.\n"),
    ASK_WINNING_NUMBER("당첨 번호를 입력해주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해주세요."),
    WINNING_STATISTICS("당첨 통계\n---"),
    YIELD_RESULTS("총 수익률은 %f%입니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
