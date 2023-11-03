package lotto.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoReward;
import lotto.domain.money.MoneyCondition;

public record WinningResults(Map<LottoReward, Integer> results) {

    public static WinningResults from(final List<LottoReward> rewards) {
        return new WinningResults(rewards.stream()
                .collect(Collectors.groupingBy(lottoReward -> lottoReward,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue))));
    }

    public int getRewardCount(final LottoReward lottoReward) {
        return results.getOrDefault(lottoReward, 0);
    }

    public double calculatePercentageReturn() {
        int totalPrize = 0;
        int count = 0;
        for (LottoReward key : results.keySet()) {
            totalPrize += results.get(key) * key.getPrize();
            count += results.get(key);
        }
        return totalPrize / (double) (count * MoneyCondition.MONEY_UNIT.value()) * 100;
    }
}
