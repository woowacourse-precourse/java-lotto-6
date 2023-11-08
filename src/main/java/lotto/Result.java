package lotto;

import java.util.List;

public enum Result {
    zero(0,0,0,0),
    one(1, 6, 0, 2000000000),
    two(2, 5, 1, 30000000),
    three(3, 5, 0, 1500000),
    four(4, 4, 0, 50000),
    five(5, 3, 0, 5000);

    private final int rank;
    private final int matchingCount;
    private final int bonus;
    private final int price;

    Result(int rank, int matchingCount, int bonus, int price) {
        this.rank = rank;
        this.matchingCount= matchingCount;
        this.bonus = bonus;
        this.price = price;

    }

    public int getRank() {
        return rank;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getBonus() {
        return bonus;
    }

    public int getPrice() {
        return price;
    }

}