package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.LottoCalculator;
import lotto.domain.lottery.Lottos;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.constants.PrintMessage.PRINT_REQUEST_PURCHASE_PAYMENT;

public class LottoMachine {
    public Lottos purchase() {
        OutputView.printMessage(PRINT_REQUEST_PURCHASE_PAYMENT);
        Buyer buyer = readPayment();

        return Lottos.create(buyer.getTicketCount());
    }

    private static Buyer readPayment() {
        try {
            String paymentInput = InputView.readLine();
            return Buyer.from(paymentInput);
        } catch (LottoException exception) {
            OutputView.println(exception.getMessage());
            return readPayment();
        }
    }

    private static int cal(final int payment) {
        return LottoCalculator.calculateLottoTicketCount(payment);
    }
}
