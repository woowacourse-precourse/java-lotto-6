package lotto.constant;

public enum RankingMessage {
    MATCH_THREE_MESSAGE("3개 일치 (5,000원)"),
    MATCH_FOUR_MESSAGE("4개 일치 (50,000원)"),
    MATCH_FIVE_MESSAGE("5개 일치 (1,500,000원)"),
    MATCH_BONUS_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_SIX_MESSAGE("6개 일치 (2,000,000,000원)")
    ;

    private final String message;
    RankingMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
