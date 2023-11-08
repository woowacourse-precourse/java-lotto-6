package lotto.model;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private long countMatch;
    private int money;

    Rank(long countMatch, int money) {
        this.countMatch = countMatch;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static Rank lottoRank(long countMatch, boolean matchBonus) {
        if (countMatch == 6) {
            return FIRST;
        }
        if (countMatch == 5 && matchBonus == true) {
            return SECOND;
        }
        if (countMatch == 5 ) {
            return THIRD;
        }
        if (countMatch == 4 ) {
            return FOURTH;
        }
        if (countMatch == 3 ) {
            return FIFTH;
        }
        return MISS;
    }
}
