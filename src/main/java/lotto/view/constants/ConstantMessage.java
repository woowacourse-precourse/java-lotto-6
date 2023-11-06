package lotto.view.constants;

public enum ConstantMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESPONSE_TICKET_AMOUNT("%d개를 구매했습니다."),
    RESPONSE_WINNING_STATISTICS("당첨 통계"),
    RESPONSE_HYPHEN_SEPARATOR("---"),
    MATCHING_WINNING_NUMBER("개 일치"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    MATCHING_BONUS_NUMBER("보너스 볼 일치"),
    FIVE_THOUSAND("5,000"),
    FIFTY_THOUSAND("50,000"),
    ONE_POINT_FIVE_MILLION("1,500,000"),
    THIRTY_MILLION("30,000,000"),
    TWO_BILLION("2,000,000,000"),
    WINNING_COUNT("%d개"),
    RESPONSE_FIFTH(THREE.getMessage()
            + MATCHING_WINNING_NUMBER.getMessage()
            + " (" + FIVE_THOUSAND.getMessage() + "원) - " + WINNING_COUNT.getMessage()),
    RESPONSE_FOURTH(FOUR.getMessage()
            + MATCHING_WINNING_NUMBER.getMessage()
            + " (" + FIFTY_THOUSAND.getMessage() + "원) - " + WINNING_COUNT.getMessage()),
    RESPONSE_THIRD(FIVE.getMessage()
            + MATCHING_WINNING_NUMBER.getMessage()
            + " (" + ONE_POINT_FIVE_MILLION.getMessage() + "원) - " + WINNING_COUNT.getMessage()),
    RESPONSE_SECOND(FIVE.getMessage()
            + MATCHING_WINNING_NUMBER.getMessage() + ", " + MATCHING_BONUS_NUMBER.getMessage()
            + " (" + THIRTY_MILLION.getMessage() + "원) - " + WINNING_COUNT.getMessage()),
    RESPONSE_FIRST(SIX.getMessage()
            + MATCHING_WINNING_NUMBER.getMessage()
            + " (" + TWO_BILLION.getMessage() + "원) - " + WINNING_COUNT.getMessage()),
    RESPONSE_PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    public static void printConstantMessage(ConstantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }

    public static void printConstantMessage(ConstantMessage constantMessage, Object number) {
        System.out.printf((constantMessage.getMessage()) + "%n", number);
    }

    public String getMessage() {
        return message;
    }
}
