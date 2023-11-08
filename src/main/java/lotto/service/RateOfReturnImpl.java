package lotto.service;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class RateOfReturnImpl implements RateOfReturn {

    @Override
    public float compute(List<Integer> matchResult) {
        int reward = 0;
        for (int result : matchResult) {
            if (isFifthPrize(result)) {
                reward += Prize.FIFTH.getReward();
            } else if (isForthPrize(result)) {
                reward += Prize.FORTH.getReward();
            } else if (isThirdPrize(result)) {
                reward += Prize.THIRD.getReward();
            } else if (isSecondPrize(result)) {
                reward += Prize.SECOND.getReward();
            } else if (isFirstPrize(result)) {
                reward += Prize.FIRST.getReward();
            }
        }
        return computeRoR(reward, matchResult.size());
    }

    private float computeRoR(int reward, int LottoCount) {
        return (float) reward / (LottoCount * Lottos.LOTTO_PRICE) * 100;
    }

    private boolean isFirstPrize(int result) {
        return result == Prize.FIRST.getThreshold();
    }

    private boolean isSecondPrize(int result) {
        return result == Prize.SECOND.getThreshold();
    }

    private boolean isThirdPrize(int result) {
        return result == Prize.THIRD.getThreshold();
    }

    private boolean isForthPrize(int result) {
        return result == Prize.FORTH.getThreshold();
    }

    private boolean isFifthPrize(int result) {
        return result == Prize.FIFTH.getThreshold();
    }

}
