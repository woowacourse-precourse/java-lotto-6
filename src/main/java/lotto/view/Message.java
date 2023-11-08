package lotto.view;

public enum Message {

    PURCHASE_AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_LOTTO_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("\n보너스 번호를 입력해 주세요."),

    PURCHASED_MESSAGE("%d개를 구매했습니다."),
    ERROR_MESSAGE("[ERROR]"),
    RESULT_HEAD_LINE_MESSAGE("당첨 통계"),
    RESULT_SEPARATE_LINE_MESSAGE("---"),
    LOTTO_RESULT_MESSAGE("%d개 일치 (%,d원) - %d개"),
    LOTTO_BONUS_RESULT_MESSAGE("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    DECIMAL_PATTERN("#.#"),
    RESULT_TOTAL_PROFITABILITY_PERCENT_MESSAGE("총 수익률은 %,.1f%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
