package lotto.constant;

public enum Winning {
    FIRST(MatchNumber.SIX, BonusMatchType.NOT_APPLICABLE, 2000000000),
    SECOND(MatchNumber.FIVE, BonusMatchType.MATCH, 30000000),
    THIRD(MatchNumber.FIVE, BonusMatchType.MISMATCH, 1500000),
    FOURTH(MatchNumber.FOUR, BonusMatchType.NOT_APPLICABLE, 50000),
    FIFTH(MatchNumber.THREE, BonusMatchType.NOT_APPLICABLE, 5000);

    private MatchNumber matchNumber;
    private BonusMatchType bonus;
    private int money;

    Winning(MatchNumber number, BonusMatchType bonus, int money) {
        this.matchNumber = number;
        this.bonus = bonus;
        this.money = money;
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
