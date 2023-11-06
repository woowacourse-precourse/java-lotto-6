package lotto.controller;

import lotto.domain.Payment;
import lotto.exception.ParserException;
import lotto.exception.PaymentException;
import lotto.exception.PaymentExceptionMessage;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class PaymentController {
    public Payment createPayment(){
        OutputView.printPaymentMessage();
        Payment payment = generatePaymentFromAmount();
        return payment;
    }
    private Payment generatePaymentFromAmount(){
        try{
            Integer amount = requestAmount();
            return new Payment(amount);
        } catch (PaymentException exception){
            OutputView.printErrorMessage(exception.getMessage());
            return generatePaymentFromAmount();
        }
    }
    private Integer requestAmount(){
        String amountInfo = InputView.readLine();
        try{
            Integer amount = Parser.parseInfoToNumber(amountInfo);
            return amount;
        } catch (ParserException exception){
            throw new PaymentException(PaymentExceptionMessage.NOT_NUMBER);
        }
    }
}
