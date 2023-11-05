package lotto.constant;

public enum DisplayMessages {
    SEPARATOR("---"),
    LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_QUANTITY("\n%s개를 구매했습니다."),
    REQUEST_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    PRIZE_STATISTICS("\n당첨 통계"),
    MATCH_COUNT("%d개 일치 (%,d원) - %,d개"),
    MATCH_COUNT_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %,d개"),
    TOTAL_RETURN("총 수익률은 %,.1f%%입니다."),
    FIRST_PRIZE_MATCH_COUNT("6"),
    FIRST_PRIZE_MONEY("2,000,000,000"),
    SECOND_PRIZE_MATCH_COUNT("5"),
    SECOND_PRIZE_MONEY("30,000,000"),
    THIRD_PRIZE_MATCH_COUNT("5"),
    THIRD_PRIZE_MONEY("1,500,000"),
    FOURTH_PRIZE_MATCH_COUNT("4"),
    FOURTH_PRIZE_MONEY("50,000"),
    FIFTH_PRIZE_MATCH_COUNT("3"),
    FIFTH_PRIZE_MONEY("5,000")
    ;

    private final String message;

    DisplayMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
