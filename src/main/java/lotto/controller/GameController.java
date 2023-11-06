package lotto.controller;

import lotto.domain.*;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final LottoMachine lottoMachine;
    private final Calculator calculator;
    private final Lottos lottos;
    private final PurchaseAmount purchaseAmount;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    private int coin;

    public GameController() {
        this.lottoMachine = new LottoMachine();
        this.lottos = new Lottos();
        this.purchaseAmount = new PurchaseAmount(InputView.inputPurchaseAmount());
        this.calculator = new Calculator(purchaseAmount);
        coin = Parser.parseAmountToCoin(purchaseAmount);
        OutputView.printNumberOfLottoPurchase(coin);

    }

    public void run() {
        for (int i = 0; i < coin; i++) {
            Lotto lotto = lottoMachine.createLotto();
            lottos.addLotto(lotto);
            System.out.println(lotto.toString());
        }

        this.winningNumber = new WinningNumber(InputView.inputWinningNumber());
        this.bonusNumber = new BonusNumber(InputView.inputBonusNumber());

        Result result = calculator.calculateResult(lottos.getLottos(),
                winningNumber.getWinningNumber(),
                bonusNumber.getBonusNumber());

        OutputView.printResult(result);
        OutputView.printIncomeRate(calculator, result);
    }
}
