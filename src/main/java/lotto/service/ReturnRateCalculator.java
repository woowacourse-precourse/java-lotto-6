package lotto.service;

import java.util.HashMap;
import lotto.config.LottoConfig;

public class ReturnRateCalculator {
    public float getReturnRate(HashMap<String, Integer> countByPrize, int lottoCost) {
        int totalFirstReward = rewardToNumber(LottoConfig.FIRST_PRIZE_REWARD)
                * countByPrize.get(LottoConfig.FIRST_PRIZE_REWARD);
        int totalSecondReward = rewardToNumber(LottoConfig.SECOND_PRIZE_REWARD)
                * countByPrize.get(LottoConfig.SECOND_PRIZE_REWARD);
        int totalThirdReward = rewardToNumber(LottoConfig.THIRD_PRIZE_REWARD)
                * countByPrize.get(LottoConfig.THIRD_PRIZE_REWARD);
        int totalFourthReward = rewardToNumber(LottoConfig.FOURTH_PRIZE_REWARD)
                * countByPrize.get(LottoConfig.FOURTH_PRIZE_REWARD);
        int totalFifthReward = rewardToNumber(LottoConfig.FIFTH_PRIZE_REWARD)
                * countByPrize.get(LottoConfig.FIFTH_PRIZE_REWARD);

        int totalReward = totalFirstReward + totalSecondReward + totalThirdReward
                + totalFourthReward + totalFifthReward;

        return (float) totalReward / lottoCost * LottoConfig.PERCENTAGE;
    }

    private int rewardToNumber(String reward) {
        return Integer.parseInt(reward.replace(LottoConfig.THOUSANDS_SEPARATOR, ""));
    }

}
