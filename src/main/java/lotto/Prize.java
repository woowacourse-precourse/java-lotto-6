package lotto;

public enum Prize {

    FIRST("1등", 2_000_000_000),
    SECOND("2등", 30_000_000),
    THIRD("3등", 1_500_000),
    FOURTH("4등", 50_000),
    FIFTH("5등", 5_000);


    private final String ranking;
    private final int prizeAmount;

    Prize(String ranking, int prizeAmount) {

        this.ranking = ranking;
        this.prizeAmount = prizeAmount;
    }

    public String getRanking() {
        return ranking;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
