package lotto.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoRewardCondition;
import lotto.domain.money.LottoMoneyCondition;

public record WinningResults(Map<LottoRewardCondition, Integer> results) {

    public static WinningResults from(final List<LottoRewardCondition> rewards) {
        return new WinningResults(rewards.stream()
                .collect(Collectors.groupingBy(lottoReward -> lottoReward,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue))));
    }

    public int getRewardCount(final LottoRewardCondition lottoRewardCondition) {
        return results.getOrDefault(lottoRewardCondition, 0);
    }

    public double calculateProfitRatio() {
        int totalPrizeMoney = calculateTotalPrizeMoney();
        int lottoBuyingCount = getBuyingCount();
        return totalPrizeMoney / (double) (lottoBuyingCount * LottoMoneyCondition.MONEY_UNIT.value()) * 100;
    }

    private int getBuyingCount() {
        return results.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int calculateTotalPrizeMoney() {
        return results.entrySet().stream()
                .mapToInt(result -> result.getValue() * result.getKey().getRewardMoney())
                .sum();
    }
}
