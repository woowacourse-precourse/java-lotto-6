package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmount;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private PurchaseAmount purchaseAmount;
    private int coin;
    private LottoMachine lottoMachine;

    public GameController() {
        this.lottoMachine = new LottoMachine();
        this.purchaseAmount = new PurchaseAmount(InputView.inputPurchaseAmount());
        this.coin = Parser.parseAmountToCoin(purchaseAmount);
        OutputView.printNumberOfLottoPurchase(coin);
    }

    public void run() {
        for(int i=0; i<coin; i++){
            Lotto lotto = lottoMachine.createLotto();
        }
    }


}
