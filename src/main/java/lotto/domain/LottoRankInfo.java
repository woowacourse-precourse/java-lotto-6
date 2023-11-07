package lotto.domain;

import java.util.Arrays;
import java.util.Objects;

public enum LottoRankInfo {
    FIRST(6, null, 2_000_000_000L, "6개 일치"),
    SECOND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000L, "5개 일치"),
    FOURTH(4, null, 50_000L, "4개 일치"),
    FIFTH(3, null, 5_000L, "3개 일치"),
    NONE(0, null, 0, "꽝");
    private final int hitCount;
    private final Boolean isBonusHit;
    private final long rewardPrice;
    private final String description;

    LottoRankInfo(int hitCount, Boolean isBonusHit, long rewardPrice, String description) {
        this.hitCount = hitCount;
        this.isBonusHit = isBonusHit;
        this.rewardPrice = rewardPrice;
        this.description = description;
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

    public Long getRewardPrice() {
        return rewardPrice;
    }

    public String getDescription() {
        return description;
    }
}
