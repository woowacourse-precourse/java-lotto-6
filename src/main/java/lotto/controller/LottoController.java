package lotto.controller;

import lotto.domain.Payment;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private LottoService lottoService = new LottoService();

    public void run() {
        buyTickets();
        printTickets();
    }

    private void buyTickets() {
        try {
            Payment payment = new Payment(InputView.readPayment());
            lottoService.init(payment.getLottoCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyTickets();
        }
    }

    private void printTickets() {
        OutputView.printTickets(lottoService.tickets());
    }
}
