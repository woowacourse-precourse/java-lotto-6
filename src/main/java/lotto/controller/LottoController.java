package lotto.controller;

import lotto.domain.Amount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private  Amount amount;

    public void run() {
        getLottoMoney();
        printLottoList();
    }

    private void getLottoMoney() {
        OutputView.printPurchaseAmount();
        int purchaseAmount = InputView.readPurchaseAmount();
        amount = new Amount(purchaseAmount);
    }

    private void printLottoList() {
        OutputView.printPurchaseCount(amount.getCount());
    }


}
