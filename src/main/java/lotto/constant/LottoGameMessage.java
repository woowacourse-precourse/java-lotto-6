package lotto.constant;

public enum LottoGameMessage {
    PAYMENT_AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    NUMBER_OF_LOTTO_MESSAGE("%d개를 구매했습니다."),
    WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_DETAIL_MESSAGE("당첨 통계\n---"),
    RANKING_MESSAGE("%d개 일치 (%s원) - %d개"),
    SECOND_RANKING_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    TOTAL_PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private String message;

    private LottoGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
