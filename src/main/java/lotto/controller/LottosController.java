package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.view.InputView;

public class LottosController {

    private Lottos lottos;

    public void run() {
        buyTickets();
    }

    private void buyTickets() {
        try {
            Payment payment = new Payment(InputView.readPayment());
            this.lottos = Lottos.from(payment.getLottoCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyTickets();
        }
    }
}
