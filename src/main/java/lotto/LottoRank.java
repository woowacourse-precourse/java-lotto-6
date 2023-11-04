package lotto;

public enum LottoRank {
    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000),
    NONE(0, 0, 0);

    private final int lottoCount;
    private final int bonusCount;
    private final int prize;

    LottoRank(int lottoCount, int bonusCount, int prize) {
        this.lottoCount = lottoCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    public int getPrize() {
        return prize;
    }
}