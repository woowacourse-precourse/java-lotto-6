package lotto.constant;

public enum LottoMessage {
    PURCHASE_AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO_QUANTITY_MESSAGE("%d개를 구매했습니다."),
    LOTTO_NUMBERS_OUTPUT_MESSAGE("[%d, %d, %d, %d, %d, %d]"),
    WINNING_NUMBERS_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_TITLE_MESSAGE("당첨 통계" + "\n" + "---"),
    WINNING_STATISTICS_MESSAGE("%d개 일치 (%d원) - %d개"),
    WINNING_STATISTICS_BONUS_MESSAGE("%d개 일치, 보너스 볼 일치 (%d원) - %d개"),
    TOTAL_PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
