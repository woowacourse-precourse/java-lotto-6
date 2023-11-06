package lotto.domain;

public enum Ranking {

    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000),
    NON_RANKING(0, 0, 0);

    private final Integer matchNumbers;
    private final Integer matchBonus;
    private final Integer prizeAmount;

    Ranking(Integer matchNumbers,
            Integer matchBonus,
            Integer prizeAmount) {
        this.matchNumbers = matchNumbers;
        this.matchBonus = matchBonus;
        this.prizeAmount = prizeAmount;
    }

    public static Ranking compareRanking(Integer matchNumbers, Integer bonus) {
        for (Ranking ranking : values()) {
            if (ranking.matchNumbers == matchNumbers && ranking.matchBonus == bonus) {
                return ranking;
            }
        }
        return Ranking.NON_RANKING;
    }

    public Integer getMatchNumbers() {
        return matchNumbers;
    }

    public Integer getMatchBonus() {
        return matchBonus;
    }

    public Integer getPrizeMoney() {
        return prizeAmount;
    }

}
