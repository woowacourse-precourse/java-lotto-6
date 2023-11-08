package lotto.controller;

import lotto.model.*;
import lotto.util.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoStore {
    private final LottoMachine lottoMachine;
    private final WinningStatistics winningStatistics;
    private PurchaseAmount purchaseAmount;
    private PurchaseLottos purchaseLottos;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public LottoStore(LottoMachine lottoMachine, WinningStatistics winningStatistics) {
        this.lottoMachine = lottoMachine;
        this.winningStatistics = winningStatistics;
    }

    public void visit() {
        buyLottos();
        showPurchaseLottos();
        setWinningLotto();
        setBonusNumber();
        showWinningStatistics();
    }

    public void buyLottos() {
        try {
            purchaseAmount = new PurchaseAmount(InputView.inputPurchaseAmount());
            purchaseLottos = new PurchaseLottos(lottoMachine, purchaseAmount.getPurchaseAmount());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + "\n");
            buyLottos();
        }
    }

    private void showPurchaseLottos() {
        showEmptyLine();
        OutputView.showPurchaseLottos(purchaseLottos.getCount(), purchaseLottos.getPurchaseLottos());
    }

    private void setWinningLotto() {
        showEmptyLine();
        try {
            winningLotto = new Lotto(InputView.inputWinningLotto());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + "\n");
            setWinningLotto();
        }
    }

    private void setBonusNumber() {
        showEmptyLine();
        try {
            bonusNumber = new BonusNumber(InputView.inputBonusNumber(), winningLotto.getNumbers());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + "\n");
            setBonusNumber();
        }
    }

    private void showWinningStatistics() {
        showEmptyLine();
        winningStatistics.setWinningResult(purchaseLottos.getPurchaseLottos(), winningLotto.getNumbers(), bonusNumber.getBonusNumber());
        winningStatistics.setRateOfReturn(purchaseAmount.getPurchaseAmount());
        OutputView.showWinningStatistics(winningStatistics.getWinningResult(), winningStatistics.getRateOfReturn());
    }

    private void showEmptyLine() {
        OutputView.showEmptyLine();
    }
}
