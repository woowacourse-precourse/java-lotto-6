package lotto.domain;

public enum Rank {
    FIRST(0, 7, 2000000000),
    SECOND(1, 6, 30000000),
    THIRD(2, 5, 1500000),
    FOURTH(3, 4, 50000),
    FIFTH(4, 3, 5000);

    private final int index;
    private final int point;
    private final int prize;

    Rank(int index, int point, int prize) {
        this.index = index;
        this.point = point;
        this.prize = prize;
    }


    public static int getPrizeByPoint(int point) {
        for (Rank rank : Rank.values()) {
            if (rank.getPoint() == point) {
                return rank.prize;
            }
        }
        return 0;
    }

    public static int getIndexByPrize(int prize) {
        for (Rank rank : Rank.values()) {
            if (rank.getPrize() == prize) {
                return rank.getIndex();
            }
        }
        return -1;
    }

    public int getIndex() {
        return index;
    }

    public int getPoint() {
        return point;
    }

    public int getPrize() {
        return prize;
    }
}
