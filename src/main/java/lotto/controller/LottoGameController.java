package lotto.controller;

import lotto.domain.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void run() {
        Payment payment = getPayment();
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

}
