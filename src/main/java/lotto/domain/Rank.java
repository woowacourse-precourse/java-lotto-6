package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0),
    ;

    private final long matchCount;
    private final int price;

    Rank(final long matchCount, final int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static Rank findBy(final long matchCount, final boolean isBonus) {
        if (matchCount == SECOND.matchCount && isBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount && !isBonus) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static Map<Rank, Integer> getRankCountMap() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        List<Rank> ranks = Arrays.stream(values())
                .filter(Rank::isNotNone)
                .toList();
        ranks.forEach(rank -> result.put(rank, result.getOrDefault(rank, 0)));
        return result;
    }

    public int getPrice() {
        return price;
    }

    public boolean isNotNone() {
        return this != NONE;
    }

    @Override
    public String toString() {
        String formattedPrice = String.format("%,d", price);
        if (this == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (" + formattedPrice + "원)", matchCount);
        }
        return String.format("%d개 일치 (" + formattedPrice + "원)", matchCount);
    }
}
