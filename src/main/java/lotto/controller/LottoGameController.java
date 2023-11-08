package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.model.Ranking;
import lotto.model.Revenue;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void play() {
        LottoBundle lottoBundle = LottoGenerator.getLottoBundle();

        System.out.println();
        Lotto winningLotto = InputView.getWinningLotto();

        System.out.println();
        Integer bonusNumber = InputView.getBonusNumber(winningLotto);

        LottoResult result = calculateRanking(lottoBundle, winningLotto, bonusNumber);
        OutputView.showResult(result);
    }

    private static LottoResult calculateRanking(LottoBundle lottoBundle, Lotto winningLotto,
                                                Integer bonusNumber) {
        List<Lotto> lottos = lottoBundle.getLottoBundle();
        Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        for (Lotto lotto : lottos) {
            int matchCounts = lotto.match(winningLotto);
            boolean hasBonusNumber = lotto.contains(bonusNumber);
            Ranking ranking = Ranking.checkRanking(matchCounts, hasBonusNumber);
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
        return new LottoResult(result, Revenue.from(result, lottos.size()));
    }

}
