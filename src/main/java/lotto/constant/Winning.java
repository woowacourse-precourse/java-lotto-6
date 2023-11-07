package lotto.constant;

public enum Winning {
    FIFTH("3개 일치 (5,000원)", MatchNumber.THREE, BonusMatchType.NOT_APPLICABLE, 5000),
    FOURTH("4개 일치 (50,000원)", MatchNumber.FOUR, BonusMatchType.NOT_APPLICABLE, 50000),
    THIRD("5개 일치 (1,500,000원)", MatchNumber.FIVE, BonusMatchType.MISMATCH, 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", MatchNumber.FIVE, BonusMatchType.MATCH, 30000000),
    FIRST("6개 일치 (2,000,000,000원)", MatchNumber.SIX, BonusMatchType.NOT_APPLICABLE, 2000000000);

    private String prizeMessage;
    private MatchNumber matchNumber;
    private BonusMatchType bonus;
    private int money;

    Winning(String message, MatchNumber number, BonusMatchType bonus, int money) {
        this.prizeMessage = message;
        this.matchNumber = number;
        this.bonus = bonus;
        this.money = money;
    }

    public String getPrizeMessage() {
        return prizeMessage;
    }
    public MatchNumber getMatchNumber() {
        return matchNumber;
    }

    public BonusMatchType getBonus() {
        return bonus;
    }

    public int getMoney() {
        return money;
    }
}
