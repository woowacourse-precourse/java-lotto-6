package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final WinningLottoStorage winningLottoStorage;
    private PurchasedLotto purchasedLotto;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.winningLottoStorage = new WinningLottoStorage();
    }

    public void processLotto() {
        PurchaseAmount purchaseAmount = payOnAmount();
    }

    private PurchaseAmount payOnAmount() {
        try {
            return PurchaseAmount.from(inputView.insertPurchaseAmount());
        } catch (IllegalArgumentException purchaseAmountError) {
            System.out.println(purchaseAmountError.getMessage());
            return payOnAmount();
        }
    }
}