package lotto.controller;

import lotto.domain.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PaymentController {
    public Payment createPayment(){
        OutputView.printPaymentMessage();
        Integer amount = requestAmount();
        return new Payment(amount);
    }
    private Integer requestAmount(){
        String amountInfo = InputView.readLine();
        Integer amount = Integer.parseInt(amountInfo);
        return amount;
    }
}
