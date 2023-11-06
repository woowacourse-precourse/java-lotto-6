package lotto.model.domain.result;

public enum LottoResult {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private final int prize;
    private final int collectCount;

    LottoResult(int collectCount, int prize) {
        this.collectCount = collectCount;
        this.prize = prize;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public int getPrize() {
        return prize;
    }

}