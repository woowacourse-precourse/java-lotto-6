package lotto.model.value;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Matching {

    THREE("3개 일치", 5_000, 3),
    FOUR("4개 일치", 50_000, 4),
    FIVE("5개 일치", 1_500_000, 5),
    FIVE_BONUS("5개 일치, 보너스 볼 일치", 30_000_000, 7),
    SIX("6개 일치", 2_000_000_000, 6);

    private static final Map<Integer, String> matchingMap = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Matching::getCount, Matching::name))
    );

    private final String matchingNumber;
    private final int prizeMoney;
    private final int count;

    Matching(String matchingNumber, int prizeMoney, int count) {
        this.matchingNumber = matchingNumber;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public static Matching of(final int count) {
        return Matching.valueOf(matchingMap.get(count));
    }

    public String getMatchingNumber() {
        return matchingNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }
}
