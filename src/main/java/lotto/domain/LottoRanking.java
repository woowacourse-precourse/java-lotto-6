package lotto.domain;

public enum LottoRanking {

    NO_LUCK(0, 2),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private final int prize;
    private final int correctNumberCount;

    LottoRanking(int prize, int correctNumberCount) {
        this.prize = prize;
        this.correctNumberCount = correctNumberCount;
    }

    public boolean isSameCorrectCount(int correctCount) {
        return correctNumberCount == correctCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }
}
