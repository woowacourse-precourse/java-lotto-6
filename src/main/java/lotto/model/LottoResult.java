package lotto.model;

public enum LottoResult {
    FIRST(3, 5000),
    SECOND(4, 50000),
    THIRD(5, 1500000),
    FOURTH(5, 30000000),
    FIFTH(6, 2000000000);

    private final int matchingNumbers;
    private final int prize;

    LottoResult(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrize() {
        return prize;
    }

}
