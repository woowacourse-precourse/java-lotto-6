package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoProcess {
    public List<Rank> makeRanks(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        List<LottoWinningChecker> lottoWinningCheckers = makeLottoWinningCheckers(lottos, winningLotto);

        for (LottoWinningChecker lottoWinningChecker : lottoWinningCheckers) {
            ranks.add(Rank.decideRank(lottoWinningChecker.getDuplicationCounter(),
                    lottoWinningChecker.getBonusChecker()));
        }

        return ranks;
    }

    public List<LottoWinningChecker> makeLottoWinningCheckers(List<Lotto> lottos, WinningLotto winningLotto) {
        /*List<Integer> counted = new ArrayList<>();
        List<Boolean> checked = new ArrayList<>();

        for (Lotto lotto : lottos) {
            counted.add(winningLotto.getLotto().countOverlappingNumbers(lotto));
            checked.add(lotto.isContainBonusNumber(winningLotto.getBonusNumber()));
        }

        return new LottoResult(counted, checked);*/
        List<LottoWinningChecker> lottoWinningCheckers = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottoWinningCheckers.add(new LottoWinningChecker(winningLotto.getLotto().countOverlappingNumbers(lotto),
                    lotto.isContainBonusNumber(winningLotto.getBonusNumber())));
        }

        return lottoWinningCheckers;
    }

    public List<Lotto> buyLotto(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = new Lotto(NumberGenerator.generate());
            lottos.add(lotto);
        }

        return lottos;
    }
}