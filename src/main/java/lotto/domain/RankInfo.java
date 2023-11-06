package lotto.domain;

import java.util.stream.Stream;

public enum RankInfo {
    NONE(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private final int matchNumberCnt;
    private final Long prizeMoney;

    RankInfo(int matchNumberCnt, Long prizeMoney) {
        this.matchNumberCnt = matchNumberCnt;
        this.prizeMoney = prizeMoney;
    }

    public static RankInfo getRankByValue(int value, boolean isBonusNumContained) {
        if (checkBonusNumber(value, isBonusNumContained)) {
            return SECOND;
        }

        return Stream.of(values())
                .filter(rankInfo -> rankInfo.matchNumberCnt == value)
                .findFirst()
                .orElse(NONE);
    }

    private static boolean checkBonusNumber(int value, boolean isBonusNumContained) {
        return value == SECOND.matchNumberCnt && isBonusNumContained;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

}
