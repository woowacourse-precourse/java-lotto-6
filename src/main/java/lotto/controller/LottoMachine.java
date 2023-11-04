package lotto.controller;

import lotto.domain.lottery.LottoCalculator;
import lotto.domain.lottery.Lottos;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.constants.PrintMessage.PRINT_REQUEST_PURCHASE_PAYMENT;

public class LottoMachine {
    public Lottos purchase() {
        OutputView.printMessage(PRINT_REQUEST_PURCHASE_PAYMENT);
        final int ticketCount = readPayment();

        return Lottos.create(ticketCount);
    }

    private static String readPayment() {
        try {
            return InputView.readLine();
        } catch (LottoException exception) {
            OutputView.println(exception.getMessage());
            return readPayment();
        }
    }

    private static int cal(final int payment) {
        return LottoCalculator.calculateLottoTicketCount(payment);
    }
}
