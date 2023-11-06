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

    public static Rank valueOf(int count, boolean bonus){
        if (count < 3){
            return NONE;
        }

        if (SECOND.matchCount(count) && bonus) {
            return SECOND;
        }

        for (Rank rank : values()){
            if (rank.matchCount(count) && rank != SECOND) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getCount(){
        return count;
    }

    public boolean getBonus(){
        return bonus;
    }

    public long getAward(){
        return award;
    }

    public boolean matchCount(int count){
        return this.count == count;
    }
}
