package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private UserInput userInput = new UserInput();
    private GenerateLotteries generateLotteries;
    private PurchasePrice purchasePrice;
    private Lotto lotto;
    private BonusLotto bonusLotto;

    public void startGame() {
        String price = inputView.requestPurchasePrice();
        purchasePrice = new PurchasePrice(userInput.convertToIntegerIfValid(price));

        generateLotteries = new GenerateLotteries(purchasePrice.getPurchaseCount());
        outputView.printPurchasedLotteries(generateLotteries.getLotteries());

        String numbers = inputView.requestWinningNumbers();
        lotto = new Lotto(userInput.convertToIntegerListIfValid(numbers));

        String bonusNumber = inputView.requestBonusNumber();
        bonusLotto = new BonusLotto(userInput.convertToIntegerIfValid(bonusNumber), lotto);
    }
}
