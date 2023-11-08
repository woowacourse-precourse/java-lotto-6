package lotto.domain;

public enum Rank {
    NONE(0, 0),
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);
    final private int count;
    final private long money;

    Rank(int count, long money) {
        this.count = count;
        this.money = money;
    }

    public static Rank getRankByCount(int count) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (rank.count == count) {
                return rank;
            }
        }
        return Rank.NONE;
    }

    public int getCount() {
        return count;
    }

    public long getMoney() {
        return money;
    }

}
