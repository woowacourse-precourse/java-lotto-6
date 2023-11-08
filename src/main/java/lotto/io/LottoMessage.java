package lotto.io;

public enum LottoMessage {

    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PRINT_LOTTO_COUNT("\n%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_WINNING_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    SAME_NUMBER_COUNT_MESSAGE("%d개 일치"),
    BONUS_NUMBER_MESSAGE(", 보너스 볼 일치"),
    WINNER_PRICE_MESSAGE(" (%s원) "),
    TOTAL_COUNT_MESSAGE("- %d개\n"),
    DECIMAL_FORMAT("###,###,###,###"),
    LOTTO_STATISTIC_MESSAGE("\n당첨 통계\n---\n");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
