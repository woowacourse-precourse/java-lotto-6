package lotto.constants;

public enum OutputMessages {
    LOTTO_COUNT("%d개를 구매했습니다.\n"),
    LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    WINNING_STATISTICS_DELIMITER("---------"),
    FIFTH_BONUS_RESULT("5개 일치, 보너스 볼 일치"),
    MATCH_RESULT("%s (%,d원) - %d개 일치"),
    PROFIT_MESSAGE("총 수익률은 %.1f%%입니다.");
    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
