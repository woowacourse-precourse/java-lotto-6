package lotto.domain;

public enum Rank {
    NOTHING_ZERO(0, false, 0),
    NOTHING_ONE(1, false, 0),
    NOTHING_TWO(2, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);
    private final int count;
    private final boolean bonus;
    private final long prize;

    Rank(int count, boolean bonus, long prize) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
    }

    public boolean matchRank(int count, boolean bonus) {
        if(count==5){
            return this.count == count && this.bonus==bonus;
        }
        return this.count == count;
    }

    public long getPrize() {
        return prize;
    }

    public String getFormalizedRank() {
        String result = String.format("%d개 일치", this.count);
        if (this.bonus) {
            result += ", 보너스 볼 일치";
        }
        result += String.format(" (%,d원) - ", this.prize);
        return result;
    }
}
