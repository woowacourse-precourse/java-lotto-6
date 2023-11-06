package lotto;

import lotto.controller.LottoController;
import lotto.model.Jackpot;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.model.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 로또 구매
        String amount = inputView.inputPurchaseAmount();
        Purchase purchase = lottoController.purcahseLottos(amount);
        int purchaseCount = purchase.getPurchaseCount();
        outputView.printPurchaseCount(purchaseCount);
        
    }
}
