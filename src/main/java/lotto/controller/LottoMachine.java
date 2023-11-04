package lotto.controller;

import lotto.domain.lottery.Lottos;
import lotto.domain.validator.Validator;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.parser.LottoService.calculatePurchaseTicketCount;
import static lotto.view.constants.PrintMessage.PRINT_REQUEST_PURCHASE_PAYMENT;

public class LottoMachine {
    public Lottos purchase() {
        OutputView.printMessage(PRINT_REQUEST_PURCHASE_PAYMENT);
        final int payment = readValidPayment();
        final int purchaseTicketCount = calculatePurchaseTicketCount(payment);

        return Lottos.create(purchaseTicketCount);
    }

    private static int readValidPayment() {
        try {
            int payment = InputView.readPayment();
            Validator.validateUnitPrice(payment);

            return payment;
        } catch (LottoException exception) {
            OutputView.println(exception.getMessage());
            return readValidPayment();
        }
    }
}
