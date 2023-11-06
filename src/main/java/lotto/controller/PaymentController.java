package lotto.controller;

import static lotto.view.OutputView.printEnterPurchaseAmount;
import static lotto.view.OutputView.printErrorMessage;

import lotto.domain.Payment;
import lotto.view.InputView;

public class PaymentController {
    
    public Payment receivePayment() {
        printEnterPurchaseAmount();
        return repeatUntilReceivePayment();
    }
    
    private Payment repeatUntilReceivePayment() {
        try {
            String payment = InputView.readLine();
            return Payment.from(payment);
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return repeatUntilReceivePayment();
        }
    }
}
