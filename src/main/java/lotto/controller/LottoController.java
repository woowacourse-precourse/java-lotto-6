package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPurchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public LottoController() {
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        purchaseLottoByUserAmount();
        winningNumbersSet();
        winningBonusNumberSet();
    }

    public void purchaseLottoByUserAmount() {
        long purchaseAmount = InputView.inputPurchaseAmount();
        int ticketAmount = Long.valueOf(purchaseAmount / 1000).intValue();
        OutputView.outputPurchaseLottos(LottoPurchase.purchasedLottos(ticketAmount));
    }

    public void winningNumbersSet() {
        InputView.inputWinningNumbers();
    }

    public void winningBonusNumberSet() {
        InputView.inputWinningBonusNumber();
    }
}
