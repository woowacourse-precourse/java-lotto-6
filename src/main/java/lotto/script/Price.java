package lotto.script;

public enum Price {

    PRIZE_THREE_MATCH("5,000원"),
    PRIZE_FOUR_MATCH("50,000원"),
    PRIZE_FIVE_MATCH("1,500,000원"),
    PRIZE_FIVE_MATCH_WITH_BONUS("30,000,000원"),
    PRIZE_SIX_MATCH("2,000,000,000원");

    private final String message;

    Price(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
