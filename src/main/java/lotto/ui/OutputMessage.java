package lotto.ui;

public enum OutputMessage {
    PURCHASE_AMOUNT_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_QUANTITY_FORMAT("%n%d개를 구매했습니다."),
    LOTTO_FORMAT("[%d, %d, %d, %d, %d, %d]"),

    WINNING_NUMBERS_INPUT("%n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("%n보너스 번호를 입력해 주세요."),

    WINNING_STATISTICS_DELIMITER("%n당첨 통계%n---"),
    FIFTH_PLACE_FORMAT("3개 일치 (5,000원) - %d개"),
    FOURTH_PLACE_FORMAT("4개 일치 (50,000원) - %d개"),
    THIRD_PLACE_FORMAT("5개 일치 (1,500,000원) - %d개"),
    SECOND_PLACE_FORMAT("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PLACE_FORMAT("6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN_FORMAT("총 수익률은 %.1f%%입니다."),

    ERROR_FORMAT("[ERROR] %s");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
