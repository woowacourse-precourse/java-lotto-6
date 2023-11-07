package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.controller.OutputController;
import lotto.util.LottoValues;
import lotto.util.RewardValue;

public class ReturnRateCalculator {

    public static String getReturnRate(Map<String, Integer> winningStatistics, int customerPrice) {

        List<String> messages = OutputController.getMessages(winningStatistics,true);
        List<RewardValue> rewardValues = getRewardValues();
        double returnRate = 0.0;

        for (int count = 0; count < messages.size(); count++) {
            double rewardValue = getRewardValue(rewardValues, count);
            int rewardCount = winningStatistics.get(messages.get(count));
            returnRate += getProceed(rewardValue, rewardCount);
        }
        returnRate /= customerPrice;

        return String.format("%.1f", (returnRate)*100);
    }

    private static double getRewardValue(List<RewardValue> rewardValues, int count) {
        return Double.parseDouble(rewardValues.get(count).toString().replace(LottoValues.REWARD_SPLIT_PARAMETER, ""));
    }

    private static List<RewardValue> getRewardValues() {
        return Arrays.stream(RewardValue.values()).toList();
    }

    private static double getProceed(double rewardValue, int rewardCount) {
        return rewardCount * rewardValue;
    }
}
