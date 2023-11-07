package lotto;

public enum LottoMessage {
    DELIMITER(","),
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_PURCHASE_QUANTITY("%d개를 구매했습니다."),
    ASK_WINNING_NUMBER("당첨 번호를 입력해주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해주세요."),
    WINNING_STATISTICS("당첨 통계\n---"),
    THREE_MATCHES("3개 일치 (5,000원) - %d개"),
    FOUR_MATCHES("4개 일치 (50,000원) - %d개"),
    FIVE_MATCHES("5개 일치 (1,500,000원) - %d개"),
    BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - %d개"),
    YIELD_RESULTS("총 수익률은 %f%입니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
