package lotto.controller;


import lotto.domain.Payment;
import lotto.utils.Parser;
import lotto.view.InputView;

public class GameController {

    public static void start() {

        String payInput = InputView.getPaymentFromUserInput();
        Payment payment = new Payment(Parser.parsePay(payInput));






    }
}
