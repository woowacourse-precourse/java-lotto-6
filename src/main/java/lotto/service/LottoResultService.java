package lotto.service;

import java.util.EnumMap;
import java.util.List;
import lotto.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

public class LottoResultService {

    private final WinningNumbers winningNumbers;
    private final RankCounter rankCounter;

    public LottoResultService(WinningNumbers winningNumbers, RankCounter rankCounter) {
        this.winningNumbers = winningNumbers;
        this.rankCounter = rankCounter;
    }

    public EnumMap<Rank, Integer> rank(List<Lotto> lottos) {
        lottos.stream()
                .map(winningNumbers::rank)
                .forEach(rankCounter::increaseCount);
        return rankCounter.getCountResult();
    }

    public double getRateOfReturn(int input, EnumMap<Rank, Integer> countResult) {
        double output = getTotal(countResult);
        return output / input;
    }

    private double getTotal(EnumMap<Rank, Integer> countResult) {
        return countResult.keySet()
                .stream()
                .mapToDouble(rank -> rank.amountOf(countResult.get(rank)))
                .sum();
    }
}
