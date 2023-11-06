package lotto.domain.enums;

import java.util.*;
import java.util.stream.Collectors;

public enum LottoPrize {
    FIRST(1, 2_000_000_000, 6),
    SECOND(2, 30_000_000, 5),
    THIRD(3, 1_500_000, 5),
    FOURTH(4, 50_000, 4),
    FIFTH(5, 5_000, 3),
    NONE(0, 0, 0);

    private final int rank;
    private final int prizeMoney;
    private final int matchCount;

    LottoPrize(int rank, int prizeMoney, int matchCount) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
    }

    public static LottoPrize valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public static Map<LottoPrize, Integer> lottoPrizeCount(List<LottoPrize> allLottoPrizes) {
        List<LottoPrize> ranks = List.of(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST);

        Map<LottoPrize, Integer> lottoPrizeAndCount = new HashMap<>();
        for (LottoPrize rank : ranks) {
            int count = Collections.frequency(allLottoPrizes, rank);
            lottoPrizeAndCount.put(rank, count);
        }
        return lottoPrizeAndCount;
    }
}
