package lotto.domain;

public enum Rank {
    // Values, Fields, Constructor
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


    // Features
    // 점수를 입력받으면 그에 해당하는 상금을 반환한다.
    public static int getPrizeByPoint(int point) {
        for (Rank rank : Rank.values()) {
            if (rank.point == point) {
                return rank.prize;
            }
        }
        return 0;
    }

    // 상금을 입력받으면 그에 해당하는 인덱스를 반환한다.
    public static int getIndexByPrize(int prize) {
        for (Rank rank : Rank.values()) {
            if (rank.prize == prize) {
                return rank.index;
            }
        }
        return -1;
    }

}
