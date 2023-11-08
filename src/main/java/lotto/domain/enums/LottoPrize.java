package lotto.domain.enums;

import java.util.*;
import java.util.stream.Collectors;

public enum LottoPrize {
    FIRST(1, 2000_000_000, "2,000,000,000원", 6),
    SECOND(2, 30_000_000, "30,000,000원", 5),
    THIRD(3, 1_500_000, "1,500,000원", 5),
    FOURTH(4, 50_000, "50,000원", 4),
    FIFTH(5, 5_000, "5,000원",  3),
    NONE(0, 0, "0원",  0);

    public final int rank;
    public final int prizeMoney;
    public final String prizeMoneyForPrint;
    public final int matchCount;

    LottoPrize(int rank, int prizeMoney, String prizeMoneyForPrint, int matchCount) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
        this.prizeMoneyForPrint = prizeMoneyForPrint;
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
