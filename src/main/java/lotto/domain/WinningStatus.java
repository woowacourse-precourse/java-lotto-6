package lotto.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningStatus {
    MATCH3(5000, 3),
    MATCH4(50000, 4),
    MATCH5(1500000, 5),
    MATCH5_WITH_BONUS(30000000, 8), //임의의 숫자 초기화
    MATCH6(2000000000, 6);

    private final int prize;
    private final int matchCount;

    WinningStatus(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    private int matchCount() {
        return this.matchCount;
    }

    public int getPrice() {
        return this.prize;
    }

    private static final Map<Integer, WinningStatus> BY_MATCHCOUNT =
            Stream.of(values()).collect(Collectors.toMap(WinningStatus::matchCount, Function.identity()));

    public static WinningStatus valueOfMatchCount(int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch == true) {
            return MATCH5_WITH_BONUS;
        }

        return BY_MATCHCOUNT.get(matchCount);
    }
}
