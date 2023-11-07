package lotto.domain;

import static lotto.domain.RankPrize.values;
import static lotto.domain.enums.NumberConstant.INITIAL_VALUE;
import static lotto.domain.enums.NumberConstant.ONE_COUNT;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class WinningLotto {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public void determineWinningNumbers(List<Integer> inputWinningNumbers) {
        this.winningNumbers = new Lotto(inputWinningNumbers);
    }

    public void determineBonusNumber(int inputBonusNumber) {
        this.bonusNumber = winningNumbers.hasSameNumber(inputBonusNumber);
    }

    public RankResult determineRank(Lottos purchasedLottos) {
        EnumMap<RankPrize, Integer> ranks = initializeRanks();
        purchasedLottos.getLottos()
                .forEach(purchasedLotto -> {
                    RankPrize result = purchasedLotto.determineRank(winningNumbers, bonusNumber);
                    if (result != null) {
                        ranks.compute(result, (rankPrize, winCounts) -> winCounts + ONE_COUNT.getValue());
                    }
                });
        return new RankResult(ranks);
    }

    private static EnumMap<RankPrize, Integer> initializeRanks() {
        EnumMap<RankPrize, Integer> ranks = new EnumMap<>(RankPrize.class);
        Arrays.stream(values())
                .forEach(rankPrize -> ranks.put(rankPrize, INITIAL_VALUE.getValue()));
        return ranks;
    }
}
