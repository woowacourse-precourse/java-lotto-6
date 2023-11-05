package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.constants.PrintMessage.REQUEST_PURCHASE_PAYMENT;

public class BuyerController {
    private BuyerController() {
    }

    public static Buyer requestPayment() {
        OutputView.printMessage(REQUEST_PURCHASE_PAYMENT);
        return readPaymentInfo();
    }

    private static Buyer readPaymentInfo() {
        try {
            final String paymentInput = InputView.readLine();
            return Buyer.from(paymentInput);
        } catch (LottoException exception) {
            OutputView.println(exception.getMessage());
            return readPaymentInfo();
        }
    }
}
