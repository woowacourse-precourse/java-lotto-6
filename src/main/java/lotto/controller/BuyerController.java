package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.exception.LottoException;
import lotto.view.input.InputReader;
import lotto.view.output.OutputWriter;

import static lotto.view.constants.PrintMessage.REQUEST_PURCHASE_PAYMENT;

public class BuyerController {
    private BuyerController() {
    }

    public static Buyer requestPayment() {
        OutputWriter.printMessage(REQUEST_PURCHASE_PAYMENT);
        return readPaymentInfo();
    }

    private static Buyer readPaymentInfo() {
        try {
            final String paymentInput = InputReader.readLine();
            return Buyer.from(paymentInput);
        } catch (LottoException exception) {
            OutputWriter.println(exception.getMessage());
            return readPaymentInfo();
        }
    }
}
