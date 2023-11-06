package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.result.LottoCalculateResult;
import lotto.domain.result.LottoMatchResult;
import lotto.domain.result.LottoPurchaseResult;
import lotto.domain.result.LottoWinningResult;
import lotto.domain.Purchase;
import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.RandomLottoStrategy;

public class LottoModel {
    private final LottoStrategy lottoStrategy = new RandomLottoStrategy();

    public List<Lotto> generateLottos(Purchase purchase) {
        int finalRound = purchase.getFinalRound();
        List<Lotto> lottos = new ArrayList<>();

        for (int round = 0; round < finalRound; round++) {
           Lotto lotto = new Lotto(lottoStrategy.generateNumbers());
           lottos.add(lotto);
        }
        return lottos;
    }

    public LottoMatchResult matchResult(LottoPurchaseResult lottoPurchaseResult, LottoWinningResult lottoWinningResult) {
        List<Lotto> lottos = lottoPurchaseResult.getLottos();
        List<Integer> winningNumbers = lottoWinningResult.getWinningNumbers();
        int bonusNumber = lottoWinningResult.getBonusNumber();

        LottoMatchResult lottoMatchResult = new LottoMatchResult();
        for (Lotto lotto : lottos) {
            int count = lotto.countMatches(winningNumbers);
            boolean bonusMatched = lotto.isBonusMatched(bonusNumber);

            lottoMatchResult.updateMatchResult(count, bonusMatched);
        }
        return lottoMatchResult;
    }

    public LottoCalculateResult calculateResult(LottoMatchResult lottoMatchResult, LottoPurchaseResult purchaseResult) {
        LottoCalculateResult lottoCalculateResult = new LottoCalculateResult();
        lottoCalculateResult.calculateProfitPrice(lottoMatchResult);
        lottoCalculateResult.calculateProfitPercentage(purchaseResult);
        return lottoCalculateResult;
    }
}
