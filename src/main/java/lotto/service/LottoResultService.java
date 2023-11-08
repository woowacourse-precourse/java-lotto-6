package lotto.service;

import java.util.EnumMap;
import java.util.List;
import lotto.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

public class LottoResultService {

    private final WinningNumbers winningNumbers;
    private final RankCounter rankCounter;

    public LottoResultService(final WinningNumbers winningNumbers, final RankCounter rankCounter) {
        this.winningNumbers = winningNumbers;
        this.rankCounter = rankCounter;
    }

    public EnumMap<Rank, Integer> rank(final List<Lotto> lottos) {
        lottos.stream()
                .map(winningNumbers::rank)
                .forEach(rankCounter::increaseCount);
        return rankCounter.getCountResult();
    }

    public double getRateOfReturn(final int input, final EnumMap<Rank, Integer> countResult) {
        double output = getTotal(countResult);
        return output / input;
    }

    private double getTotal(final EnumMap<Rank, Integer> countResult) {
        return countResult.keySet()
                .stream()
                .filter(rank -> rank != Rank.BLANK)
                .mapToDouble(rank -> rank.amountOf(countResult.get(rank)))
                .sum();
    }
}
