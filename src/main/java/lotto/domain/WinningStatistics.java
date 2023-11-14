package lotto.domain;

import lotto.message.ResponseMessage;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.ConstantValue.MIN_WINNING_MATCH_COUNT;

public class WinningStatistics {

    private final Map<Prize, Integer> statistics;

    public WinningStatistics() {
        statistics = new LinkedHashMap<>();
        initStatistics();
    }

    private void initStatistics() {
        Prize[] prizes = Prize.values();
        for (Prize prize : prizes) {
            statistics.put(prize, 0);
        }
    }

    public void acceptWinPrizes(List<Prize> winPrizes) {
        for (Prize prize : winPrizes) {
            Integer count = statistics.get(prize);
            statistics.put(prize, ++count);
        }
    }

    public String calculateRateOfReturn(Integer purchaseAmount) {
        Integer reward = calculateTotalReward();
        return String.format(
                ResponseMessage.RATE_OF_BENEFIT_MESSAGE, (double) reward / purchaseAmount * 100);
    }

    private Integer calculateTotalReward() {
        Integer reward = 0;
        for (Prize prize : statistics.keySet()) {
            reward += (prize.getWinningAmount() * statistics.get(prize));
        }
        return reward;
    }

    @Override
    public String toString() {
        StringBuilder statisticsFormat = new StringBuilder();
        for (Prize prize : statistics.keySet()) {
            if (prize.getMatchCount() >= MIN_WINNING_MATCH_COUNT) {
                statisticsFormat.append(
                        String.format(
                                ResponseMessage.FORMATTED_RESULT_MESSAGE,
                                prize.getPrizeMessage(),
                                adjustToFormat(prize.getWinningAmount()),
                                statistics.get(prize)
                        )
                );
            }
        }
        return statisticsFormat.toString();
    }

    private String adjustToFormat(int number) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(number);
    }
}
