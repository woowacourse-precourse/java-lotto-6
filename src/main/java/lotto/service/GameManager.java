package lotto.service;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.Lottos;
import lotto.domain.PrizeCondition;
import lotto.domain.WinningLotto;

import java.util.Map;

public class GameManager {
    private final LottoPurchaseManager lottoPurchaseManager;
    private LottoResultGenerator lottoResultGenerator;

    private GameManager(LottoPurchaseAmount lottoPurchaseAmount) {
        this.lottoPurchaseManager = LottoPurchaseManager.create(lottoPurchaseAmount);
    }

    public static GameManager create(LottoPurchaseAmount lottoPurchaseAmount) {
        return new GameManager(lottoPurchaseAmount);
    }

    public Lottos providePurchasedLottos() {
        return lottoPurchaseManager.getLottos();
    }

    public void processResult(WinningLotto winningLotto) {
        initializeLottoResultGenerator(winningLotto);
    }

    public Map<PrizeCondition, Long> providePrizeResult() {
        return lottoResultGenerator.generatePrizeResult(lottoPurchaseManager.getLottos());
    }

    public double provideProfit() {
        return lottoResultGenerator.generateProfit();
    }

    private void initializeLottoResultGenerator(WinningLotto winningLotto) {
        lottoResultGenerator = LottoResultGenerator.create(winningLotto, lottoPurchaseManager.getPurchaseAmount());
    }
}
