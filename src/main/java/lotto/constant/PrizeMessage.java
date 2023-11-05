package lotto.constant;

public enum PrizeMessage {

    FIRST(PrizeCondition.FIRST.getMatchNumbers()
            + "개 일치 ("
            + PrizeMoney.FIRST.getValueAsDecimalFormat()
            + "원) - "),
    SECOND(PrizeCondition.SECOND.getMatchNumbers()
            + "개 일치, 보너스 볼 일치 ("
            + PrizeMoney.SECOND.getValueAsDecimalFormat()
            + "원) - "),
    THIRD(PrizeCondition.THIRD.getMatchNumbers()
            + "개 일치 ("
            + PrizeMoney.THIRD.getValueAsDecimalFormat()
            + "원) - "),
    FOURTH(PrizeCondition.FOURTH.getMatchNumbers()
            + "개 일치 ("
            + PrizeMoney.FOURTH.getValueAsDecimalFormat()
            + "원) - "),
    FIFTH(PrizeCondition.FIFTH.getMatchNumbers()
            + "개 일치 ("
            + PrizeMoney.FIFTH.getValueAsDecimalFormat()
            + "원) - ");

    final String message;

    PrizeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
