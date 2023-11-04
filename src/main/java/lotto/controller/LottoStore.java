package lotto.controller;

import lotto.model.*;
import lotto.util.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoStore {
    private final InputView inputView;
    private final OutputView outputView;
    private final WinningStatistics winningStatistics;
    private final LottoMachine lottoMachine;
    private PurchaseAmount purchaseAmount;
    private PurchaseLottos purchaseLottos;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public LottoStore(InputView inputView, OutputView outputView, LottoMachine lottoMachine, WinningStatistics winningStatistics) {
        this.inputView = inputView;
        this.outputView =outputView;
        this.lottoMachine = lottoMachine;
        this.winningStatistics = winningStatistics;
    }

    public void visit() {
        buyLottos();
        divideSection();
        makeWinningLotto();
        divideSection();
        makeBonusNumber();
        divideSection();
        showWinningStatistics();
    }

    private void buyLottos() {
        try {
            inputPurchaseAmount();
            divideSection();
            showPurchaseLottos();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            divideSection();
            buyLottos();
        }
    }

    private void inputPurchaseAmount() {
        purchaseAmount = new PurchaseAmount(inputView.inputPurchaseAmount());
        purchaseLottos = new PurchaseLottos(lottoMachine, purchaseAmount.getPurchaseAmount());
    }

    private void showPurchaseLottos() {
        outputView.showPurchaseLottos(purchaseLottos.getCount(), purchaseLottos.getPurchaseLottos());
    }

    private void makeWinningLotto() {
        try {
            winningLotto = new Lotto(inputView.inputWinningLotto());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            divideSection();
            makeWinningLotto();
        }
    }

    private void makeBonusNumber() {
        try {
            bonusNumber = new BonusNumber(inputView.inputBonusNumber(), winningLotto.getNumbers());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            divideSection();
            makeBonusNumber();
        }
    }

    private void showWinningStatistics() {
        winningStatistics.setWinningResult(purchaseLottos.getPurchaseLottos(), winningLotto.getNumbers(), bonusNumber.getBonusNumber());
        winningStatistics.setRateOfReturn(purchaseAmount.getPurchaseAmount());
        outputView.showWinningStatistics(winningStatistics.getWinningResult(), winningStatistics.getRateOfReturn());
    }

    private void divideSection() {
        outputView.showEmptyLine();
    }
}
