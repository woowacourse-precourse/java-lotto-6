package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.domain.WinningLotto;
import lotto.domain.strategy.AutoIssueStrategy;
import lotto.domain.strategy.ManualIssuanceStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void run() {
        Payment payment = getPayment();
        Lottos lottos = issueLottosByAuto(payment.calculatePurchasedLottoCount());
        printPurchaseHistory(payment, lottos);

        WinningLotto winningLotto = issueWinningLottoByManual(getWinningLotto());
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

    private WinningLotto issueWinningLottoByManual(final Lotto winningLotto) {
        try {
            return new WinningLotto(winningLotto, getBonusNumber());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return issueWinningLottoByManual(winningLotto);
        }
    }

    private Lotto getWinningLotto() {
        OutputView.printWinningLottoNumbersGuide();
        try {
            String winningLottoNumbers = InputView.readInput();
            return issueLottoByManual(winningLottoNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getWinningLotto();
        }
    }

    private Lotto issueLottoByManual(final String winningLottoNumbers) {
        return new ManualIssuanceStrategy(winningLottoNumbers).issue();
    }

    private int getBonusNumber() {
        OutputView.printBonusNumberGuide();
        return Integer.parseInt(InputView.readInput());
    }

}
