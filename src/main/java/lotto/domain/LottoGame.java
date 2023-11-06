package lotto.domain;

import java.util.List;

public class LottoGame {
    private final LottoGenerator lottoGenerator;
    private final WinningLotto winningLotto = new WinningLotto();
    private PurchaseAmount purchaseAmount;
    private Lottos purchasedLottos;

    public LottoGame(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void initializePurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
    }

    public void purchaseLottos() {
        this.purchasedLottos = this.lottoGenerator.generate(this.purchaseAmount.getAvailablePurchaseCounts());
    }

    public Lottos getPurchasedLottos() {
        return this.purchasedLottos;
    }

    public void determineWinningNumbers(List<Integer> inputWinningNumbers) {
        winningLotto.determineWinningNumbers(inputWinningNumbers);
    }

    public void determineBonusNumber(int inputBonusNumber) {
        winningLotto.determineBonusNumber(inputBonusNumber);
    }

    public RankResult calculateRank() {
        return winningLotto.determineRank(this.purchasedLottos);
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount.getPurchaseAmount();
    }
}
