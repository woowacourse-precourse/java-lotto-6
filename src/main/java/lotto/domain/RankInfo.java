package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum RankInfo {
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private final int matchNumberCnt;
    private final Long prizeMoney;

    private static final Map<Integer, RankInfo> rankMap = new HashMap<>();

    static {
        for (RankInfo rankInfo : RankInfo.values()) {
            rankMap.put(rankInfo.matchNumberCnt, rankInfo);
        }
    }

    RankInfo(int matchNumberCnt, Long prizeMoney) {
        this.matchNumberCnt = matchNumberCnt;
        this.prizeMoney = prizeMoney;
    }

    public static RankInfo getRankByValue(int value, boolean isBonusNumContained) {
        if (checkBonusNumber(value, isBonusNumContained)) {
            return SECOND;
        }
        return rankMap.get(value);
    }

    private static boolean checkBonusNumber(int value, boolean isBonusNumContained) {
        return value == SECOND.matchNumberCnt && isBonusNumContained;
    }

    public int getMatchNumberCnt() {
        return matchNumberCnt;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

}
