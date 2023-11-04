package lotto.domain;

public enum Rank {
    FIRST(7, 2000000000),
    SECOND(6, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int point;
    private final int prize;

    Rank(int point, int prize) {
        this.point = point;
        this.prize = prize;
    }

    public static int getPrizeByPoint(int point) {
        for (Rank rank : Rank.values()) {
            if (rank.getPoint() == point) {
                return rank.prize;
            }
        }
        return -1;
    }

    public int getPoint() {
        return point;
    }
}
