package lotto.service;


import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseCount;


public class LottoGameService {

    private final NumberGenerator numberGenerator;

    public LottoGameService() {
        numberGenerator = new RandomNumberGenerator();
    }

    public List<Lotto> purchase(PurchaseCount purchaseCount) {
        return purchaseCount.purchase(numberGenerator);
    }

    public LottoResult play(LottoGame lottoGame) {
        LottoResult lottoResult = new LottoResult();
        List<Integer> countResults = lottoGame.play();
        List<Boolean> bonusResults = lottoGame.checkBonus();
        lottoResult.calculateResults(countResults, bonusResults);
        return lottoResult;
    }
}
