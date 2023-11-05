package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;

public class LottoRankCalculatorService {

    public List<LottoRank> calculateRanks(List<Lotto> lottos, WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> LottoRank.of(
                        winningNumbers.countMatchingNumber(lotto),
                        winningNumbers.bonusNumberMatch(lotto)))
                .collect(Collectors.toList());
    }

}
