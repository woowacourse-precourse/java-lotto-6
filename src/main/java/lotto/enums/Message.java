package lotto.enums;

public enum Message {
    INPUT_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASE_QUANTITY_MESSAGE("개를 구매했습니다."),
    OUTPUT_WINNING_STATISTICS_MESSAGE("당첨 통계"),
    OUTPUT_DIVIDING_LINE("---"),
    OUTPUT_COUNT_UNIT("개"),
    OUTPUT_PROFIT_RATIO_MESSAGE("총 수익률은 %.1f%%입니다.");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
