package lotto.controller;

import lotto.domain.PurchaseLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void run() {
        try {
            System.out.println("\n" + getPurChaseAmount() + OutputView.printPurchaseLottoCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private static int getPurChaseAmount() {
        OutputView.printInputPurchaseAmount();
        String lottoCount = InputView.inputPurchaseAmount();
        return PurchaseLotto.getLottoCount(lottoCount);
    }
}
