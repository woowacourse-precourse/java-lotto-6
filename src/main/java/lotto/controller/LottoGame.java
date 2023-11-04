package lotto.controller;

import lotto.domain.LottoPurchase;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame implements Game {

    private LottoPurchase lottoPurchase;
    private LottoTickets lottoTickets;

    @Override
    public void run() {
        collectPurchaseAmount();
        printLottoTickets();
    }

    private void collectPurchaseAmount() {
        try {
            lottoPurchase = new LottoPurchase(InputView.lottoPurchaseAmountInput());
            lottoTickets = lottoPurchase.generateLottoTickets();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            collectPurchaseAmount();
        }
    }

    private void printLottoTickets() {
        OutputView.printNumberOfPurchasedLottoTickets(lottoPurchase.getNumberOfTickets());
        OutputView.printPurchasedLottoNumbers(lottoTickets.getLottoTickets());
    }
}
