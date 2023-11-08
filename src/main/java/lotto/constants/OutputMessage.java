package lotto.constants;

public enum OutputMessage {
    MONEY_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    ANSWER_LOTTO_INPUT_MESSAGE("당첨 번호를 입력해주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해주세요."),
    LOTTO_RESULT_MESSAGE("당첨 통계"),
    LOTTO_PURCHASE_COUNT_MESSAGE("%d개를 구매했습니다."),
    EARNING_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
