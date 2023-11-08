package lotto.service;

import lotto.domain.payment.Payment;

import lotto.exception.ParserException;
import lotto.exception.PaymentException;
import lotto.exception.message.PaymentExceptionMessage;

import lotto.util.Parser;

import lotto.view.InputView;
import lotto.view.OutputView;

public class PaymentService {
    public Payment createPayment() {
        Payment payment = generatePaymentFromAmount();
        return payment;
    }

    private Payment generatePaymentFromAmount() {
        try {
            Integer amount = requestAmount();
            return Payment.of(amount);
        } catch (PaymentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return generatePaymentFromAmount();
        }
    }

    private Integer requestAmount() {
        String amountInfo = InputView.readLine();
        try {
            Integer amount = Parser.parseInfoToNumber(amountInfo);
            return amount;
        } catch (ParserException exception) {
            throw new PaymentException(PaymentExceptionMessage.NOT_NUMBER);
        }
    }
}
