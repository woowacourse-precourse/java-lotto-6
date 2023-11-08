package lotto.domain;

public enum Rank {
    FIRST_RANK(6, 2000000000),
    SECOND_RANK(5, 30000000),
    THIRD_RANK(5, 1500000),
    FOURTH_RANK(4, 50000),
    FIFTH_RANK(3, 5000);

    private final int matchingNum;
    private final int prize;

    Rank(int matchingNum, int prize) {
        this.matchingNum = matchingNum;
        this.prize = prize;
    }

    public int getMatchingNum() {
        return matchingNum;
    }

    public int getPrize() {
        return prize;
    }

}
