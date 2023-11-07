package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Rank {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOUR(4, false, 50000L),
    FIVE(3, false, 5000L),
    NONE(0, false, 0L);

    private Integer matchedNumberCount;
    private Boolean isBonusNumberMatched;
    private Long prizeAmount;

    Rank(Integer matchedNumberCount, Boolean isBonusNumberMatched, Long priceAmount) {
        this.matchedNumberCount = matchedNumberCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.prizeAmount = priceAmount;
    }

    public static Rank findRankBy(int matchingCount, Boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(r -> r.hasRank(matchingCount, hasBonus))
                .findFirst()
                .orElse(NONE);
    }

    public static List<Rank> getAllRank() {
        return Arrays.stream(Rank.values())
                .filter(r -> !r.equals(Rank.NONE))
                .sorted(Comparator.comparing(Rank::getPrizeAmount))
                .toList();
    }

    public Long getPrizeAmount() {
        return this.prizeAmount;
    }

    private boolean hasRank(int matchingCount, Boolean hasBonus) {
        return this.matchedNumberCount == matchingCount && this.isBonusNumberMatched.equals(hasBonus);
    }

}
