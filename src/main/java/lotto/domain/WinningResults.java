package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.state.WinningStatisticsState.MessagePerCount;

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

    public List<MessagePerCount> getWinningMessages() {
        return value.entrySet()
                .stream()
                .map(this::getWinningMessage)
                .toList();
    }

    private MessagePerCount getWinningMessage(Entry<LottoRewardTable, Long> lottoRewardTableLongEntry) {
        final var rewardTable = lottoRewardTableLongEntry.getKey();
        final var winningCount = lottoRewardTableLongEntry.getValue();
        return new MessagePerCount(rewardTable.getMessage(), winningCount);
    }

}
