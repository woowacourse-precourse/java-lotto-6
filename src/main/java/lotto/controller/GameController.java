package lotto.controller;

import lotto.domain.*;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final PurchaseAmount purchaseAmount;
    private final int coin;
    private final LottoMachine lottoMachine;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public GameController() {
        this.lottoMachine = new LottoMachine();
        this.purchaseAmount = new PurchaseAmount(InputView.inputPurchaseAmount());
        this.coin = Parser.parseAmountToCoin(purchaseAmount);
        OutputView.printNumberOfLottoPurchase(coin);
    }

    public void run() {
        for (int i = 0; i < coin; i++) {
            Lotto lotto = lottoMachine.createLotto();
            System.out.println(lotto.toString());
        }

        winningNumber = new WinningNumber(InputView.inputWinningNumber());
        bonusNumber = new BonusNumber(InputView.inputBonusNumber());
    }
}
