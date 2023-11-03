package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        int purchasePrice = getPurchasePrice();
        int lottoCount = getLottoCount(purchasePrice);
        OutputView.printPurchaseLotto(lottoCount);
    }

    private int getLottoCount(int purchasePrice) {
        return purchasePrice / 1000;
    }

    private int getPurchasePrice() {
        OutputView.printInputPrice();
        return InputView.getPurchaseLottoPrice();
    }

}
