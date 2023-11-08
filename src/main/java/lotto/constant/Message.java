package lotto.constant;

public enum Message {
    NULL(null),
    INPUT_BUDGET("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTO_COUNT_MESSAGE("개를 구매했습니다."),
    RESULT_MESSAGE("당첨 통계"),
    RATE_OF_RETURN_PREFIX("총 수익률은 "),
    RATE_OF_RETURN_SUFFIX("%입니다.");;

    private final String message;

    Message(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
