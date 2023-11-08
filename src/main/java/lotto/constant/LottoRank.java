package lotto.constant;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_LUCK(null, 0);

    private final Integer sameCount;
    private final Long rewardMoney;

    LottoRank(Integer sameCount, long rewardMoney) {
        this.sameCount = sameCount;
        this.rewardMoney = rewardMoney;
    }

    public static LottoRank getRank(int sameCount, boolean isBonus) {
        if (sameCount == FIRST.sameCount) {
            return FIRST;
        }
        if (sameCount == SECOND.sameCount && isBonus) {
            return SECOND;
        }
        if (sameCount == THIRD.sameCount && !isBonus) {
            return THIRD;
        }
        if (sameCount == FOURTH.sameCount) {
            return FOURTH;
        }
        if (sameCount == FIFTH.sameCount) {
            return FIFTH;
        }
        if (sameCount < FIFTH.sameCount) {
            return NO_LUCK;
        }
        throw new IllegalStateException();
    }

    public int getSameCount() {
        return sameCount;
    }

    public long getRewardMoney() {
        return rewardMoney;
    }

    public String getRewardMoneyFormat() {
        return NumberFormat.getInstance().format(rewardMoney);
    }

    public static List<LottoRank> getLottoRanksExceptNoLuck() {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NO_LUCK)
                .collect(Collectors.toList());
    }
}
