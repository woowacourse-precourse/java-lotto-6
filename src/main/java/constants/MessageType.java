package constants;

public enum MessageType {

    HOW_MANY_BUY("개를 구매했습니다."),
    SHOW_RESULT("당첨 통계"),
    SHOW_DASH("---"),
    COMMA(","),
    THREE_EQUAL("3개 일치 (5,000원) - "),
    FOUR_EQUAL("4개 일치 (50,000원) - "),
    FIVE_EQUAL_WITH_NO_BOUNS("5개 일치 (1,500,000원) - "),
    FIVE_EQUAL_WITH_BOUNS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_EQUAL("6개 일치 (2,000,000,000원) - "),
    UNIT("개"),
    SHOW_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");
    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
