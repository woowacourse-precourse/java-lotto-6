package lotto.constant;

public enum PrizeMessage {

    FIRST(PrizeCondition.FIRST.getMatchNumbers()
            + "개 일치 ("
            + PrizeMoney.FIRST.getValueWithDelimiter()
            + "원) - "),
    SECOND(PrizeCondition.SECOND.getMatchNumbers()
            + "개 일치, 보너스 볼 일치 ("
            + PrizeMoney.SECOND.getValueWithDelimiter()
            + "원) - "),
    THIRD(PrizeCondition.THIRD.getMatchNumbers()
            + "개 일치 ("
            + PrizeMoney.THIRD.getValueWithDelimiter()
            + "원) - "),
    FOURTH(PrizeCondition.FOURTH.getMatchNumbers()
            + "개 일치 ("
            + PrizeMoney.FOURTH.getValueWithDelimiter()
            + "원) - "),
    FIFTH(PrizeCondition.FIFTH.getMatchNumbers()
            + "개 일치 ("
            + PrizeMoney.FIFTH.getValueWithDelimiter()
            + "원) - ");

    private final String message;

    PrizeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
