package lotto.controller;

import lotto.domain.LottoPurchase;
import lotto.view.InputView;

public class LottoGame implements Game {

    private LottoPurchase lottoPurchase;
    @Override
    public void run() {
        collectPurchaseAmount();
    }

    private void collectPurchaseAmount () {
        try {
            lottoPurchase = new LottoPurchase(InputView.lottoPurchaseAmountInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            collectPurchaseAmount();
        }
    }
}
