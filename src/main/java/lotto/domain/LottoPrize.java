package lotto.domain;

public enum LottoPrize {
    FIRST("1등", 2_000_000_000),
    SECOND("2등", 30_000_000),
    THIRD("3등", 1_500_000),
    FOURTH("4등", 50_000),
    FIFTH("5등", 5_000);
    private final String rank;
    private final long prizeAmount;


    LottoPrize(String rank, long prizeAmount) {
        this.rank = rank;
        this.prizeAmount = prizeAmount;
    }

    public String getRank() {
        return rank;
    }

    public Long getPrizeAmount() {
        return prizeAmount;
    }

}
