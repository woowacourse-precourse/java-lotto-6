package lotto.constant;

public enum Message {
    LINE_BREAKING("\n"),
    INPUT_MONEY("구입금액을 입력해 주세요."),
    PURCHASE_LOTTO("%d개를 구매했습니다."),
    INPUT_PRIZE_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRIZE_STATISTICS("당첨 통계\n---"),
    FIFTH("3개 일치 (5,000원) - %d개"),
    FOURTH("4개 일치 (50,000원) - %d개"),
    THIRD("5개 일치 (1,500,000원) - %d개"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST("6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
