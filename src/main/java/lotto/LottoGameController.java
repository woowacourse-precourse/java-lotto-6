package lotto;

import lotto.domain.GenerateLotteries;
import lotto.domain.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private GenerateLotteries generateLotteries;
    private PurchasePrice purchasePrice;

    public void startGame() {
        purchasePrice = new PurchasePrice(inputView.requestPurchasePrice());

        generateLotteries = new GenerateLotteries(purchasePrice.getPurchaseCount());

        outputView.printPurchasedLotteries(generateLotteries.getLotteries());
    }
}
