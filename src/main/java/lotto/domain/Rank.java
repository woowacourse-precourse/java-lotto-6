package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.dto.MatchResult;

public enum Rank {
    NONE(0, false, 0L),
    FIFTH(3, false, 5_000L),
    FOURTH(4, false, 50_000L),
    THIRD(5, false, 1_500_000L),
    SECOND(5, true, 30_000_000L),
    FIRST(6, false, 2_000_000_000L);

    private final int matchCount;
    private final boolean hasBonus;
    private final long prize;
    private static final Map<Integer, Rank> scoreCache = new HashMap<>();

    static {
        Arrays.stream(Rank.values())
                .forEach(rank -> {
                    int score = getScore(rank.matchCount, rank.hasBonus);
                    scoreCache.put(score, rank);
                    scoreCache.put(score + 1, rank);
                });
    }

    Rank(int matchCount, boolean hasBonus, long prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    private static int getScore(int matchCount, boolean hasBonus) {
        int score = matchCount * 2;
        if (hasBonus) {
            score++;
        }
        return score;
    }

    public static Rank of(MatchResult matchResult) {
        return of(matchResult.matchCount(), matchResult.hasBonus());
    }

    private static Rank of(int matchCount, boolean hasBonusNumber) {
        int score = getScore(matchCount, hasBonusNumber);
        return scoreCache.getOrDefault(score, NONE);
    }

    public static long getTotalPrize(Map<Rank, Integer> rankResult) {
        return rankResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().prize * entry.getValue())
                .sum();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public long getPrize() {
        return prize;
    }
}
