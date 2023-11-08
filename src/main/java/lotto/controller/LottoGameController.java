package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.LottoGenerator;
import lotto.model.RankingResult;
import lotto.view.InputView;

public class LottoGameController {

    public void play() {
        LottoBundle lottoBundle = LottoGenerator.getLottoBundle();

        Lotto winningLotto = InputView.getWinningLotto();
        Integer bonusNumber = InputView.getBonusNumber(winningLotto);

        Map<RankingResult, Integer> rankingResult = calculateRanking(lottoBundle, winningLotto, bonusNumber);

    }

    private static Map<RankingResult, Integer> calculateRanking(LottoBundle lottoBundle, Lotto winningLotto,
                                                                Integer bonusNumber) {
        List<Lotto> lottos = lottoBundle.getLottoBundle();
        Map<RankingResult, Integer> result = new EnumMap<>(RankingResult.class);
        for (Lotto lotto : lottos) {
            int matchCounts = lotto.match(winningLotto);
            boolean hasBonusNumber = lotto.contains(bonusNumber);
            RankingResult ranking = RankingResult.checkRanking(matchCounts, hasBonusNumber);
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
        return result;
    }

}
