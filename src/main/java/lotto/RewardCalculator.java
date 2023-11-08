package lotto;

import java.util.Collections;
import java.util.List;

import lotto.LottoEnum.Prize;

public class RewardCalculator {
    public int getReward(Prize lottoResult) {
        if (lottoResult == Prize.FIRST) {
            return 2000000000;
        } else if (lottoResult == Prize.SECOND) {
            return 30000000;
        } else if (lottoResult == Prize.THIRD) {
            return 1500000;
        } else if (lottoResult == Prize.FOURTH) {
            return 50000;
        } else if (lottoResult == Prize.FIFTH) {
            return 5000;
        }

        return 0;
    }

    public int getTotalReward(List<Prize> lottoResults) {
        int totalReward = 0;

        for (Prize lottoResult : lottoResults) {
            totalReward += getReward(lottoResult);
        }

        return totalReward;
    }
}
