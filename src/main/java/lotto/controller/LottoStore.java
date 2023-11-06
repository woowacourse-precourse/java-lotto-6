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
            showEmptyLine();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            showEmptyLine();
            buyLottos();
        }
    }

    private void showPurchaseLottos() {
        OutputView.showPurchaseLottos(purchaseLottos.getCount(), purchaseLottos.getPurchaseLottos());
        showEmptyLine();
    }

    private void setWinningLotto() {
        try {
            winningLotto = new Lotto(InputView.inputWinningLotto());
            showEmptyLine();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            showEmptyLine();
            setWinningLotto();
        }
    }

    private void setBonusNumber() {
        try {
            bonusNumber = new BonusNumber(InputView.inputBonusNumber(), winningLotto.getNumbers());
            showEmptyLine();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            showEmptyLine();
            setBonusNumber();
        }
    }

    private void showWinningStatistics() {
        winningStatistics.setWinningResult(purchaseLottos.getPurchaseLottos(), winningLotto.getNumbers(), bonusNumber.getBonusNumber());
        winningStatistics.setRateOfReturn(purchaseAmount.getPurchaseAmount());
        OutputView.showWinningStatistics(winningStatistics.getWinningResult(), winningStatistics.getRateOfReturn());
    }

    private void showEmptyLine() {
        OutputView.showEmptyLine();
    }
}
