package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.domain.strategy.AutoIssueStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void run() {
        Payment payment = getPayment();
        Lottos lottos = issueLottosByAuto(payment.calculatePurchasedLottoCount());
        printPurchaseHistory(payment, lottos);
    }

    private Payment getPayment() {
        OutputView.printPaymentGuide();
        try {
            return new Payment(InputView.readInput());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getPayment();
        }
    }

    private Lottos issueLottosByAuto(final int totalCount) {
        return new Lottos(totalCount, new AutoIssueStrategy());
    }

    private void printPurchaseHistory(final Payment payment, final Lottos lottos) {
        OutputView.printPurchasedLottoCount(payment);
        OutputView.printIssuedLottosNumbers(lottos.getLottoNumbersDto());
    }

}
