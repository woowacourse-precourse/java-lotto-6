package lotto;

import lotto.domain.GenerateLotteries;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.UserInput;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private UserInput userInput = new UserInput();
    private GenerateLotteries generateLotteries;
    private PurchasePrice purchasePrice;
    private Lotto lotto;

    public void startGame() {
        String price = inputView.requestPurchasePrice();
        purchasePrice = new PurchasePrice(userInput.convertToIntegerIfValid(price));

        generateLotteries = new GenerateLotteries(purchasePrice.getPurchaseCount());
        outputView.printPurchasedLotteries(generateLotteries.getLotteries());

        String numbers = inputView.requestWinningNumbers();
        lotto = new Lotto(userInput.convertToIntegerListIfValid(numbers));
    }
}
