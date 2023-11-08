package lotto.service;

import static lotto.view.OutputView.printEnterPurchaseAmount;
import static lotto.view.OutputView.printErrorMessage;

import lotto.domain.Payment;
import lotto.exception.LottoGameException;
import lotto.view.InputView;

public class PaymentService {
    
    public Payment receivePayment() {
        printEnterPurchaseAmount();
        return repeatUntilReceivePayment();
    }
    
    private Payment repeatUntilReceivePayment() {
        try {
            final String payment = InputView.readLine();
            return Payment.from(payment);
        } catch (LottoGameException exception) {
            printErrorMessage(exception);
            return repeatUntilReceivePayment();
        }
    }
}
