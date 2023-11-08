package lotto.view.constant;

public enum OutputMessageConstants {
    PURCHASE_AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT_OUTPUT_MESSAGE("%d개를 구매했습니다."),
    WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_RESULT_OUTPUT_MESSAGE("당첨 통계"),
    DIVIDER_OUTPUT_MESSAGE("---");

    private final String message;

    OutputMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
