package model;

public enum LottoResult {
    FIRST(6, "1등", 2_000_000_000),
    SECOND(5, "2등", 30_000_000),
    THIRD(5, "3등", 1_500_000),
    FOURTH(4, "4등", 50_000),
    FIFTH(3, "5등", 5_000);

    private final int matchingCount;
    private final String name;
    private final long prizeAmount;

    LottoResult(int matchingCount, String name, long prizeAmount) {
        this.matchingCount = matchingCount;
        this.name = name;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public String getName() {
        return name;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }
}

