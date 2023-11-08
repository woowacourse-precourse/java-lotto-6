package lotto.domain;

import java.util.stream.Stream;

public enum RankInfo {
    NONE(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private final Integer matchNumberCnt;
    private final Long prizeMoney;

    RankInfo(Integer matchNumberCnt, Long prizeMoney) {
        this.matchNumberCnt = matchNumberCnt;
        this.prizeMoney = prizeMoney;
    }

    public static RankInfo getRankByValue(Integer value, boolean isBonusNumContained) {
        if (checkBonusNumber(value, isBonusNumContained)) {
            return SECOND;
        }

        return Stream.of(values())
                .filter(rankInfo -> rankInfo.matchNumberCnt.equals(value))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean checkBonusNumber(Integer value, boolean isBonusNumContained) {
        return value.equals(SECOND.matchNumberCnt) && isBonusNumContained;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

}
