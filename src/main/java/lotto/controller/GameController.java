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
    private final int coin;

    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public GameController() {
        this.lottoMachine = new LottoMachine();
        this.calculator = new Calculator();
        this.lottos = new Lottos();
        this.purchaseAmount = new PurchaseAmount(InputView.inputPurchaseAmount());
        this.coin = Parser.parseAmountToCoin(purchaseAmount);
        OutputView.printNumberOfLottoPurchase(coin);
    }

    public void run() {
        for (int i = 0; i < coin; i++) {
            Lotto lotto = lottoMachine.createLotto();
            lottos.addLotto(lotto);
            System.out.println(lotto.toString());
        }

        winningNumber = new WinningNumber(InputView.inputWinningNumber());
        bonusNumber = new BonusNumber(InputView.inputBonusNumber());
    }
}
