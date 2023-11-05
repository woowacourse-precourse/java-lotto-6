package lotto.controller;


import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    public static void start() {

        String payInput = InputView.getPaymentFromUserInput();
        Payment payment = new Payment(Parser.parsePay(payInput));

        OutputView.printLottoAmount(payment.calculateLottoAmount());

        //Lottos lottos = new Lottos(payment.calculateLottoAmount());




    }
}
