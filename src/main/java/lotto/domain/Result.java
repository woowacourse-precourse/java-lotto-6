package lotto.domain;

import org.assertj.core.util.Maps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public enum Result {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private static final Map<Result, Integer> DEFAULT_STATISTICS_BOARD;

    static {
        DEFAULT_STATISTICS_BOARD = new LinkedHashMap<>();
        Arrays.stream(Result.values())
                .sorted(Comparator.comparing(Result::getPrize))
                .forEach(result -> DEFAULT_STATISTICS_BOARD.put(result, 0));
    }

    private final int hitCount;
    private final boolean isMustHitBonus;
    private final int prize;

    Result(int hitCount, boolean isMustHitBonus, int prize) {
        this.hitCount = hitCount;
        this.isMustHitBonus = isMustHitBonus;
        this.prize = prize;
    }

    public static Result matchFrom(int hitCount, boolean isBonusHit) {
        return Arrays.stream(Result.values())
                .filter(result -> result.hitCount == hitCount)
                .filter(result -> result.checkBonus(isBonusHit))
                .findFirst()
                .orElse(MISS);
    }

    public static Map<Result, Integer> getDefaultStatisticsBoard() {
        return new LinkedHashMap<>(DEFAULT_STATISTICS_BOARD);
    }

    private boolean checkBonus(boolean isBonusHit) {
        if (this.isMustHitBonus) {
            return isBonusHit;
        }
        return true;
    }

    public int getPrize() {
        return prize;
    }

    public int getHitCount() {
        return hitCount;
    }

    public boolean isMustHitBonus() {
        return isMustHitBonus;
    }
}
