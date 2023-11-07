package lotto.view.output;

public enum ResultMessage {
    RESULT("당첨 통계"),
    DIVIDING_LINE("---"),
    THREE_NUMBERS("3개 일치 (5,000원) - %d개"),
    FOUR_NUMBERS("4개 일치 (50,000원) - %d개"),
    FIVE_NUMBERS("5개 일치 (1,500,000원) - %d개"),
    FIVE_NUMBERS_AND_BONUS_NUMBER("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_NUMBERS("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_PROFIT("총 수익률은 %.1f%%입니다.");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
