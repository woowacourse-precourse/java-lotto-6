package lotto.lottosystem.bussiness;

public enum LottoStatus {
    WIN3(3, 5000),
    WIN4(4, 50000),
    WIN5(5, 1500000),
    WIN5_WITH_BONUS(5, 30000000),
    WIN6(6, 2000000000),
    NOT_MATCHING(0,0);

    private final int matchCount;
    private final int prize;

    LottoStatus(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
