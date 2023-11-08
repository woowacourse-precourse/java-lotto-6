package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FORTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int numberMatches;
    private final boolean bonusNumberCheck;
    private final int price;

    LottoRank(int numberMatches, boolean bonusNumberCheck, int price) {
        this.numberMatches = numberMatches;
        this.bonusNumberCheck = bonusNumberCheck;
        this.price = price;
    }

    public int numberMatches() {
        return this.numberMatches;
    }
    public int price() {
        return this.price;
    }
    public boolean bonusNumberCheck() {
        return this.bonusNumberCheck;
    }
}
