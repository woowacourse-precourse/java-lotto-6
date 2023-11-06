package lotto.controller;

import lotto.domain.*;
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
        String inputPayment = InputView.inputPayment();
        Payment payment = Payment.create(inputPayment);

        int coin = Parser.parseAmountToCoin(payment);
        OutputView.printNumberOfLotto(coin);
        for (int i = 0; i < coin; i++) {
            Lotto lotto = LottoMachine.createLotto();
            lottos.addLotto(lotto);
            System.out.println(lotto);
        }

        String inputWinningNumber = InputView.inputWinningNumber();
        WinningNumber winningNumber = WinningNumber.create(inputWinningNumber);

        String inputBonusNumber = InputView.inputBonusNumber();
        BonusNumber bonusNumber = BonusNumber.create(inputBonusNumber);

        Result result = calculator.calculateResult(lottos.getLottos(),
                winningNumber.getWinningNumber(),
                bonusNumber.getBonusNumber());
        OutputView.printResult(result);

        double incomeRate = calculator.calculateIncomeRate(result, payment);
        OutputView.printIncomeRate(incomeRate);
    }
}
