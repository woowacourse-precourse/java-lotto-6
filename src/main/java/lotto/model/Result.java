package lotto.model;

import java.util.Arrays;

public enum Result {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    FALSE(0, 0, 0),
    ;

    Result(int hitsNumberCount, int hitsBonusCount, int prizeMoney) {
        this.hitsNumberCount = hitsNumberCount;
        this.hitsBonusCount = hitsBonusCount;
        this.prizeMoney = prizeMoney;
    }

    public static Result getResult(HitsNumber hitsNumber) {
        return Arrays.stream(Result.values())
                .filter(o
                        -> o.hitsBonusCount == hitsNumber.getHitsBonusNumberCnt()
                        && o.hitsNumberCount == hitsNumber.getHitsNumberCnt())
                .findAny().orElse(FALSE);
    }

    private final int hitsNumberCount;
    private final int hitsBonusCount;
    private final int prizeMoney;

    public int getHitsNumberCount() {
        return hitsNumberCount;
    }

    public int getHitsBonusCount() {
        return hitsBonusCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return "Result{" +
                "hitsNumberCount=" + hitsNumberCount +
                ", hitsBonusCount=" + hitsBonusCount +
                ", prizeMoney=" + prizeMoney +
                '}';
    }
}
