package lotto.domain.constants;

public enum LotteryMessageConstant {
    JOIN_SYMBOL(" - "),
    MATCH_MESSAGE(" 일치"),
    COUNT_UNIT("개"),
    BONUS_BALL_MESSAGE("보너스 볼"),
    PROFIT_MESSAGE_PREFIX("총 수익률은 "),
    PROFIT_MESSAGE_SUFFIX("%입니다."),
    LOTTO_NUMBER_PREFIX("["),
    LOTTO_NUMBER_SUFFIX("]"),
    DELIMITER(", "),
    REWARD_PREFIX(" ("),
    REWARD_SUFFIX(")"),
    REWARD_UNIT("원");

    private final String message;

    LotteryMessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
