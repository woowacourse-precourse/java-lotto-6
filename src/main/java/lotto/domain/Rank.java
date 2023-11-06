package lotto.domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private int count;
    private boolean bonus;

    private long award;

    Rank(int count, boolean bonus, long award){
        this.count = count;
        this.bonus = bonus;
        this.award = award;
    }
}
