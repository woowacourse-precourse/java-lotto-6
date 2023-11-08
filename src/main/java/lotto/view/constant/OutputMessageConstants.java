package lotto.view.constant;

public enum OutputMessageConstants {
    PURCHASE_AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT_OUTPUT_MESSAGE("%d개를 구매했습니다."),
    WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_RESULT_OUTPUT_MESSAGE("당첨 통계"),
    DIVIDER_OUTPUT_MESSAGE("---"),
    WINNING_RANK_AND_COUNT_OUTPUT_MESSAGE("%d개 일치 (%,d원) - %d개"),
    SECOND_RANK_AND_COUNT_OUTPUT_MESSAGE("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    RATE_OF_RETURN_OUTPUT_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
