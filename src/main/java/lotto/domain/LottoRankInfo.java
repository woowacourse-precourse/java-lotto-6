package lotto.domain;

import java.util.Arrays;
import java.util.Objects;

public enum LottoRankInfo {
    FIRST(6, null, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, null, 50_000L),
    FIFTH(3, null, 5_000L),
    NONE(0, null, 0);
    private final int hitCount;
    private final Boolean isBonusHit;
    private final long rewardPrice;

    LottoRankInfo(int hitCount, Boolean isBonusHit, long rewardPrice) {
        this.hitCount = hitCount;
        this.isBonusHit = isBonusHit;
        this.rewardPrice = rewardPrice;
    }

    public static LottoRankInfo createLottoRank(int hitCount, Boolean isBonusHit) {
        return findMatchRank(hitCount, isBonusHit);
    }

    private static LottoRankInfo findMatchRank(int hitCount, Boolean isBonusHit) {
        return Arrays.stream(LottoRankInfo.values())
                .filter(e -> isMatch(e, hitCount, isBonusHit))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isMatch(LottoRankInfo e, int hitCount, Boolean isBonusHit) {
        if (e.isBonusHit == null) {
            return hitCount == e.hitCount;
        }
        return hitCount == e.hitCount
                && Objects.equals(isBonusHit, e.isBonusHit);
    }

    Long getRewardPrice() {
        return rewardPrice;
    }
}
