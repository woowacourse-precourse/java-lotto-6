package lotto.controller;

import lotto.domain.*;
import lotto.dto.BonusNumber;
import lotto.dto.Payment;
import lotto.domain.WinningNumber;
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
        String inputPayment = InputView.inputPayment();
        Payment payment = Payment.create(inputPayment);

        createLottos(payment.getPayment());

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
