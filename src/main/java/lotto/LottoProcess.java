package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoProcess {
    public List<Lotto> buyLotto(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = new Lotto(NumberGenerator.generate());
            lottos.add(lotto);
        }

        return lottos;
    }

    public List<Rank> makeRanks(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        List<LottoComparison> lottoComparisons = makeLottoComparisons(lottos, winningLotto);

        for (LottoComparison lottoComparison : lottoComparisons) {
            ranks.add(Rank.decideRank(lottoComparison.getCountDuplication(),
                    lottoComparison.getCheckBonus()));
        }

        return ranks;
    }

    private List<LottoComparison> makeLottoComparisons(List<Lotto> lottos, WinningLotto winningLotto) {
        List<LottoComparison> lottoComparisons = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottoComparisons.add(new LottoComparison(winningLotto.getLotto().countDuplicatingNumbers(lotto),
                    lotto.isContainBonusNumber(winningLotto.getBonusNumber())));
        }

        return lottoComparisons;
    }
}