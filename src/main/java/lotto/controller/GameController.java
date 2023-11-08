package lotto.controller;

import lotto.domain.*;
import lotto.dto.BonusNumber;
import lotto.dto.Payment;
import lotto.dto.WinningNumber;
import lotto.utils.Calculator;
import lotto.utils.LottoMachine;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final Calculator calculator;
    private final Lottos lottos;

    public GameController() {
        this.lottos = new Lottos();
        this.calculator = new Calculator();
    }

    public void run() {
        Payment payment = Payment.create(InputView.inputPayment());
        createLottos(payment.getPayment());

        WinningNumber winningNumber = WinningNumber.create(InputView.inputWinningNumber());
        BonusNumber bonusNumber = BonusNumber.create(InputView.inputBonusNumber());
        Result result = calculator.calculateResult(lottos.getLottos(),
                winningNumber.getWinningNumber(),
                bonusNumber.getBonusNumber());

        OutputView.printResult(result);
        OutputView.printIncomeRate(calculator.calculateIncomeRate(result, payment));
    }

    private void createLottos(int payment){
        int coin = Parser.parsePaymentToCoin(payment);
        OutputView.printNumberOfLotto(coin);
        for (int i = 0; i < coin; i++) {
            Lotto lotto = LottoMachine.createLotto();
            lottos.addLotto(lotto);
            System.out.println(lotto);
        }
    }
}
