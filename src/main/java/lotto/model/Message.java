package lotto.model;

public enum Message {
    ASK_MONEY("구입금액을 입력해 주세요."),
    LOTTO_COUNT("개를 구매했습니다."),
    ASK_WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    STATISTICS("\n당첨 통계\n---"),
    TOTAL_YIELD("총 수익률은 %s%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
