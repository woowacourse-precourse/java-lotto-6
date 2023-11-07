package lotto.constant;

import java.sql.PreparedStatement;
import java.text.NumberFormat;

import static lotto.constant.ConsoleMessage.LOTTO_RANK_FORMAT;
import static lotto.constant.ConsoleMessage.LOTTO_SECOND_RANK_FORMAT;

public enum LottoRank {
    FIRST(6,  2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    ETC(null, 0);

    private final Integer sameCount;
    private final Long rewardMoney;
    LottoRank(Integer sameCount, long rewardMoney) {
        this.sameCount = sameCount;
        this.rewardMoney = rewardMoney;
    }

    public static LottoRank getRank(int sameCount, boolean isBonus) {
        if(sameCount == FIRST.sameCount) {
            return FIRST;
        } if(sameCount == SECOND.sameCount && isBonus) {
            return SECOND;
        } if(sameCount == THIRD.sameCount && !isBonus) {
            return THIRD;
        } if(sameCount == FOURTH.sameCount) {
            return FOURTH;
        } if(sameCount == FIFTH.sameCount) {
            return FIFTH;
        } if (sameCount < FIFTH.sameCount) {
            return ETC;
        }
        throw new IllegalStateException();
    }
    public int getSameCount() {
        return sameCount;
    }

    public long getRewardMoney() {
        return rewardMoney;
    }

    @Override
    public String toString() {
        String rewardMoney = NumberFormat.getInstance().format(getRewardMoney());

        if(this == LottoRank.SECOND) {
            return String.format(LOTTO_SECOND_RANK_FORMAT, getSameCount(), rewardMoney);
        }
        return String.format(LOTTO_RANK_FORMAT, getSameCount(), rewardMoney);
    }
}
