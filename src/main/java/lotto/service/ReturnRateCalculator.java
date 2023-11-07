package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.controller.OutputController;
import lotto.util.RewardValue;

public class ReturnRateCalculator {

    public static String getReturnRate(Map<String, Integer> winningStatistics, int customerPrice) {

        List<String> messages = OutputController.getMessages(winningStatistics,true);
        List<RewardValue> rewardValues = Arrays.stream(RewardValue.values()).toList();
        double returnRate = 0.0;

        for (int count = 0; count < messages.size(); count++) {
            double rewardValue = Double.parseDouble(rewardValues.get(count).toString().replace(",",""));
            int rewardCount = winningStatistics.get(messages.get(count));
            returnRate += getProceed(rewardValue, rewardCount);
        }

        return String.format("%.1f", (returnRate / customerPrice)*100);
    }
    private static double getProceed(double rewardValue, int rewardCount) {
        return rewardCount * rewardValue;
    }
}
