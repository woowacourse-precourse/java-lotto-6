package lotto.controller;

import lotto.domain.Customer;
import lotto.handler.InputHandler;
import lotto.message.GuideMessage;

public class LottoGameController {
    private final InputHandler inputHandler;

    public LottoGameController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        System.out.println(GuideMessage.GET_PAYMENT_REQUEST_MESSAGE);
        int payment = inputHandler.getPayment();

        Customer customer = Customer.createCustomer(payment);
        customer.buyLottos();
        customer.printInfoOfLottos();

        System.out.println(GuideMessage.GET_TARGET_NUMBERS_REQUEST_MESSAGE);
        inputHandler.getTargetNumbers();
    }
}
