package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final PurchaseAmount purchaseAmount;
    private final int coin;
    private final LottoMachine lottoMachine;
    private WinningNumber winningNumber;

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
    }
}
