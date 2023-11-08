package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public record WinningResults(Map<LottoRewardTable, Long> value) {

    private long calculateProfitBy(Entry<LottoRewardTable, Long> lottoRewardTableLongEntry) {
        final var rewardTable = lottoRewardTableLongEntry.getKey();
        final var winningCount = lottoRewardTableLongEntry.getValue();
        return rewardTable.getReward() * winningCount;
    }

    public long calculateProfit() {
        return value.entrySet().stream()
                .mapToLong(this::calculateProfitBy)
                .sum();
    }

    public <T> List<T> convert(BiFunction<String, Long, T> function) {
        return value.entrySet().stream()
                .map(entry -> function.apply(entry.getKey().getMessage(), entry.getValue()))
                .toList();
    }

}
