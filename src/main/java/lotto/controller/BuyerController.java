package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Parser;
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
            final int payment = Parser.parseStringToInt(paymentInput);

            return Buyer.from(payment);
        } catch (LottoException exception) {
            OutputWriter.println(exception.getMessage());
            return readPaymentInfo();
        }
    }
}
