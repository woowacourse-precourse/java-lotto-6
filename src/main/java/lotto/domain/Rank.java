package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    NONE(0, 0L, (matchedCount, isBonus) -> matchedCount < 3,
        ""),
    FIFTH(3, 5_000L, (matchedCount, isBonus) -> matchedCount == 3,
        "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50_000L, (matchedCount, isBonus) -> matchedCount == 4,
        "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1_500_000L, (matchedCount, isBonus) -> matchedCount == 5 && !isBonus,
        "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30_000_000L, (matchedCount, isBonus) -> matchedCount == 5 && isBonus,
        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2_000_000_000L, (matchedCount, isBonus) -> matchedCount == 6,
        "6개 일치 (2,000,000,000원) - %d개");

    private final int count;
    private final Long prize;
    private final BiPredicate<Integer, Boolean> predicate;
    private final String statisticsFormat;

    Rank(int count, Long prize, BiPredicate<Integer, Boolean> predicate, String statisticsFormat) {
        this.count = count;
        this.prize = prize;
        this.predicate = predicate;
        this.statisticsFormat = statisticsFormat;
    }

    public static Rank valueOf(int matchedCount, boolean isBonus) {
        return Arrays.stream(values())
            .filter(prize -> prize.predicate.test(matchedCount, isBonus))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public String getStatisticsFormat() {
        return statisticsFormat;
    }
}
