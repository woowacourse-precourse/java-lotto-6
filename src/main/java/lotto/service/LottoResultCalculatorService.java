package lotto.service;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;

public class LottoResultCalculatorService {
    public LottoResult calculateRanks(List<Lotto> lottos, WinningNumbers winningNumbers) {
        EnumMap<LottoRank, Integer> ranks = new EnumMap<>(LottoRank.class);
        lottos.stream()
                .map(lotto -> LottoRank.of(
                        winningNumbers.countMatchingNumber(lotto),
                        winningNumbers.bonusNumberMatch(lotto)))
                .forEach(rank -> ranks.put(rank, ranks.getOrDefault(rank, 0) + 1));
        return LottoResult.from(ranks);
    }
}
