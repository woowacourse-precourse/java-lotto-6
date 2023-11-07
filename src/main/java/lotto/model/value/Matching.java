package lotto.model.value;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Matching {

    THREE("3개 일치", "5,000원", 5000, 3),
    FOUR("4개 일치", "50,000원", 50000, 4),
    FIVE("5개 일치", "1,500,000원", 1500000, 5),
    FIVE_BONUS("5개 일치, 보너스 볼 일치", "30,000,000원", 30000000, 7),
    SIX("6개 일치", "2,000,000,000원", 2000000000, 6);

    private static final Map<Integer, String> matchingMap = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Matching::getCount, Matching::name))
    );

    private final String matchingNumber;
    private final String prizeMoney;
    private final int money;
    private final int count;

    Matching(String matchingNumber, String prizeMoney, int money, int count) {
        this.matchingNumber = matchingNumber;
        this.prizeMoney = prizeMoney;
        this.money = money;
        this.count = count;
    }

    public static Matching of(final int count) {
        return Matching.valueOf(matchingMap.get(count));
    }

    public String getMatchingNumber() {
        return matchingNumber;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }
}
