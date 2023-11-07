package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoReceipt {
    private final List<Lotto> drawnLotteries;
    private final int lotteryCount;

    public LottoReceipt(List<Lotto> drawnLotteries) {
        this.drawnLotteries = drawnLotteries;
        this.lotteryCount = drawnLotteries.size();
    }

    public Map<Rank, Integer> getResults(WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = new HashMap<>();
        gatherMatchDetails(winningNumbers)
                .stream()
                .map(Rank::from)
                .forEach(rank -> {
                    int count = result.getOrDefault(rank, 0);
                    result.put(rank, count + 1);
                });

        return result;
    }

    private List<MatchDetail> gatherMatchDetails(WinningNumbers winningNumbers) {
        return drawnLotteries.stream()
                .map(winningNumbers::match)
                .toList();
    }

    public int getLotteryCount() {
        return lotteryCount;
    }
}
