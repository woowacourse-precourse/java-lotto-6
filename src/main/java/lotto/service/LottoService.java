package lotto.service;

import lotto.domain.*;

public class LottoService {
    private PurchaseAmount purchaseAmount;
    private PurchasedLottos purchasedLottos;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;
    private WinningStatistics winningStatistics;

    public void setPurchasedLottos(String inputAmount) {
        this.purchaseAmount = new PurchaseAmount(inputAmount);
        this.purchasedLottos = new PurchasedLottos(this.purchaseAmount);
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public PurchasedLottos getPurchasedLottos() {
        return purchasedLottos;
    }

    public void setWinningLotto(String inputWinningNumbers) {
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers);
        this.winningLotto = winningLotto.getLotto();
    }

    public void setBonusNumber(String inputBonusNumber) {
        this.bonusNumber = new BonusNumber(inputBonusNumber, winningLotto);
    }

    public void calculateWinningStatistics() {
        winningStatistics = new WinningStatistics();
        winningStatistics.updateWinningStatistics(
                purchasedLottos.getLottos(), winningLotto, bonusNumber.getBonusNumber());
    }

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }

    public String getWinningRate() {
        return winningStatistics.getWinningRate(purchaseAmount.getAmount());
    }
}
