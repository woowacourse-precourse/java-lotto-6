package lotto.constant;

public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    BUY_MESSAGE_WITH_COUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    START_STATISTICS("당첨 통계\n---"),
    RATE_OF_RETURN_START("총 수익률은 "),
    RATE_OF_RETURN_END("입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}