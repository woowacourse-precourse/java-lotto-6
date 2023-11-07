package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.service.TotalStatCalculator;
import lotto.util.OutputMessage;
import lotto.util.RewardValue;

public class OutputController {
    private TotalStatCalculator totalStatCalculator;

    public OutputController(TotalStatCalculator totalStatCalculator) {
        this.totalStatCalculator = totalStatCalculator;
    }

    public void printLottoPapers(List<Lotto> lottos, int lottoCount) {
        System.out.println(String.format(OutputMessage.LOTTO_PRINT_TITLE.toString(), lottoCount));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningStatistics(int customerPrice) {
        Map<String, Integer> winningStatistics = totalStatCalculator.getTotalLottoStats();
        String returnRate = getReturnRate(winningStatistics, customerPrice);

        System.out.println(OutputMessage.TOTAL_STATISTICS_TITLE);
        System.out.println(OutputMessage.TOTAL_PARAMETER);
        for (String message : winningStatistics.keySet()) {
            System.out.println(String.format(OutputMessage.TOTAL_STATISTICS_MESSAGE.toString(), message,
                    winningStatistics.get(message)));
        }
        System.out.println(String.format(OutputMessage.TOTAL_RETURN_VALUE_MESSAGE.toString(), returnRate));
    }

    private String getReturnRate(Map<String, Integer> winningStatistics, int customerPrice) {

        List<String> messages = winningStatistics.keySet().stream().toList();
        List<RewardValue> rewardValues = Arrays.stream(RewardValue.values()).toList();
        double returnRate = 0.0;

        for (int count = 0; count < messages.size(); count++) {
            double rewardValue = Double.parseDouble(rewardValues.get(count).toString());
            int rewardCount = winningStatistics.get(messages.get(count));
            returnRate += getProceed(rewardValue, rewardCount);
        }

        return String.format("%.2f", returnRate / customerPrice);
    }

    private double getProceed(double rewardValue, int rewardCount) {
        return rewardCount * rewardValue;
    }
}
