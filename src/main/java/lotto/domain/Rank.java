package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIFTH(3, List.of(true, false), new BigDecimal(5_000L), "3개 일치 (5,000원)"),
    FOURTH(4, List.of(true, false), new BigDecimal(50_000L), "4개 일치 (50,000원)"),
    THIRD(5, List.of(false), new BigDecimal(1_500_000L), "5개 일치 (1,500,000원)"),
    SECOND(5, List.of(true), new BigDecimal(30_000_000L), "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, List.of(true, false), new BigDecimal(2_000_000_000L), "6개 일치 (2,000,000,000원)"),
    NONE(0, List.of(true, false), new BigDecimal(0L), "없음");

    private final int matchCounts;
    private final List<Boolean> matchBonus;
    private final BigDecimal prize;
    private final String prizeMessage;

    Rank(int matchCounts, List<Boolean> matchBonus, BigDecimal prize, String prizeMessage) {
        this.matchCounts = matchCounts;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.prizeMessage = prizeMessage;
    }

    public static Rank calculateRank(final int matchCounts, final boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> isMatchRank(matchCounts, matchBonus, rank))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isMatchRank(int matchCounts, boolean matchBonus, Rank rank) {
        return rank.matchCounts == matchCounts && rank.matchBonus.contains(matchBonus);
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public String getPrizeMessage() {
        return prizeMessage;
    }
}
