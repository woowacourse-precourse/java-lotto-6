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
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    private int coin;

    public GameController() {
        this.lottoMachine = new LottoMachine();
        this.calculator = new Calculator();
        this.lottos = new Lottos();
        this.purchaseAmount = new PurchaseAmount(InputView.inputPurchaseAmount());
        OutputView.printNumberOfLottoPurchase(coin);
        this.winningNumber = new WinningNumber(InputView.inputWinningNumber());
        this.bonusNumber = new BonusNumber(InputView.inputBonusNumber());
    }

    public void run() {
        coin = Parser.parseAmountToCoin(purchaseAmount);

        for (int i = 0; i < coin; i++) {
            Lotto lotto = lottoMachine.createLotto();
            lottos.addLotto(lotto);
            System.out.println(lotto.toString());
        }

        calculator.calculateResult(lottos.getLottos(),
                winningNumber.getWinningNumber(),
                bonusNumber.getBonusNumber());


    }
}
