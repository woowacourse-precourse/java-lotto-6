package lotto.constant;

public enum ViewMessage {

    INPUT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_LOTTO_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),

    LOTTO_PURCHASE_AMOUNT_MESSAGE("개를 구매했습니다.\n"),
    WINNING_STATISTICS_MESSAGE("\n당첨 통계\n---"),
    COUNT_MESSAGE("개"),
    TOTAL_RETURN_MESSAGE("총 수익률은 ");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
