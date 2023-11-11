package lotto.constant;

public enum PrizeMessage {

    FIRST(PrizeCondition.FIRST.getMatchNumbers()
            + Constants.NUMBERS_SAME
            + PrizeMoney.FIRST.getValueWithDelimiter()
            + Constants.WON),
    SECOND(PrizeCondition.SECOND.getMatchNumbers()
            + Constants.NUMBERS_SAME_AND_BONUS_SAME
            + PrizeMoney.SECOND.getValueWithDelimiter()
            + Constants.WON),
    THIRD(PrizeCondition.THIRD.getMatchNumbers()
            + Constants.NUMBERS_SAME
            + PrizeMoney.THIRD.getValueWithDelimiter()
            + Constants.WON),
    FOURTH(PrizeCondition.FOURTH.getMatchNumbers()
            + Constants.NUMBERS_SAME
            + PrizeMoney.FOURTH.getValueWithDelimiter()
            + Constants.WON),
    FIFTH(PrizeCondition.FIFTH.getMatchNumbers()
            + Constants.NUMBERS_SAME
            + PrizeMoney.FIFTH.getValueWithDelimiter()
            + Constants.WON);

    private final String message;

    private static class Constants {
        private static final String NUMBERS_SAME = "개 일치 (";
        private static final String WON = "원) - ";
        private static final String NUMBERS_SAME_AND_BONUS_SAME = "개 일치, 보너스 볼 일치 (";
    }

    PrizeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
