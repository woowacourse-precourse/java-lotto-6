package lotto.constant;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.ErrorMessage.ENTER_PROPER_SAME_COUNT;
import static lotto.constant.NumericConstant.MUST_BE_DIFFERENT;
import static lotto.constant.NumericConstant.MUST_BE_SAME;
import static lotto.constant.NumericConstant.NOT_AFFECTED;

public enum LottoRank {
    FIRST(6, NOT_AFFECTED, 2_000_000_000),
    SECOND(5, MUST_BE_SAME, 30_000_000),
    THIRD(5, MUST_BE_DIFFERENT, 1_500_000),
    FOURTH(4, NOT_AFFECTED, 50_000),
    FIFTH(3, NOT_AFFECTED, 5_000),
    NO_LUCK(2, NOT_AFFECTED, 0); // sameCount가 2이하면 NO_LUCK, getRank()참고

    private final Integer sameCount;
    private final int bonusStatus;
    private final Long rewardMoney;

    LottoRank(Integer sameCount, int bonusStatus, long rewardMoney) {
        this.sameCount = sameCount;
        this.bonusStatus = bonusStatus;
        this.rewardMoney = rewardMoney;
    }

    public static LottoRank getRank(int sameCount, boolean isBonus) {
        for (LottoRank rank : values()) {
            if (sameCount <= NO_LUCK.sameCount) {
                return NO_LUCK;
            }
            if (sameCount == rank.sameCount && rank.bonusStatus == NOT_AFFECTED) {
                return rank;
            }
            if (sameCount == rank.sameCount && rank.bonusStatus == MUST_BE_DIFFERENT && !isBonus) {
                return rank;
            }
            if (sameCount == rank.sameCount && rank.bonusStatus == MUST_BE_SAME && isBonus) {
                return rank;
            }
        }
        throw new IllegalArgumentException(ENTER_PROPER_SAME_COUNT);
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
