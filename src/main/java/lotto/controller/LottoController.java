package lotto.controller;

import lotto.Converter;
import lotto.constant.Number;
import lotto.constant.ExceptionMessage;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {
    int ticketCount;

    public void start() throws IllegalArgumentException{
        OutputHandler.requirePaymentPrice();
        String paymentPrice = InputHandler.getPaymentPrice();
        OutputHandler.printEmptyLine();
        ticketCount = getLotteryCount(paymentPrice);
        OutputHandler.sayTicketCount(ticketCount);
    }

    int getLotteryCount(String inputPay) throws IllegalArgumentException{
        int paymentPrice = Converter.pay(inputPay);
        if (paymentPrice < 0) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_POSITIVE_INTEGER);
        }
        if (paymentPrice % Number.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_MULTIPLE_OF_LOTTO_PRICE);
        }
        return paymentPrice / Number.LOTTO_PRICE;
    }
}
