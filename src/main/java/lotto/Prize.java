package lotto;

public enum Prize {

    FIRST(6,"1등", 2_000_000_000),
    SECOND(5,"2등", 30_000_000),
    THIRD(5,"3등", 1_500_000),
    FOURTH(4,"4등", 50_000),
    FIFTH(3,"5등", 5_000);

    private final Integer matchingNumber;
    private final String ranking;
    private final Integer prizeAmount;

    Prize(Integer matchingNumber, String ranking, Integer prizeAmount) {
        this.matchingNumber = matchingNumber;
        this.ranking = ranking;
        this.prizeAmount = prizeAmount;
    }

    public Integer getMatchingNumber() {
        return matchingNumber;
    }

    public String getRanking() {
        return ranking;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
