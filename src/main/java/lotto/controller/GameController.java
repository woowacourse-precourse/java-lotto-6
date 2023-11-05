package lotto.controller;


import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.utils.Generator;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    public static void start() {

        String payInput = InputView.getPaymentFromUserInput();
        Payment payment = new Payment(Parser.parsePay(payInput));

        List<Lotto> generatedLotto = Generator.generateLottoByAmount(payment.calculateLottoAmount());
        Lottos lottos = new Lottos(generatedLotto);

        OutputView.printLottoAmount(lottos.getLottosAmount());
        OutputView.printGeneratedLottos(lottos.getLottosNumber());





    }
}
