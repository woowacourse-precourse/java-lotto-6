package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoMachine;
import lotto.service.PurchasingService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private PurchasingService purchasingService = new PurchasingService();
    private Buyer buyer;
    private LottoMachine lottoMachine;

    public void run() {
     purchaseLotto();
     showPurchaseLotto();
     inputWinningNumbers();

    }

    private void purchaseLotto() {
        String amount = InputView.enterPurchaseAmount();
        buyer = purchasingService.purchaseLotto(amount);
    }

    private void showPurchaseLotto() {
        OutputView.printPurchaseLotto(buyer);
    }

    private void inputWinningNumbers() {
        String winningNumbers = InputView.enterWinningNumbers();
        String bonusNumber = InputView.enterBonusNumbers();
        lottoMachine = new LottoMachine(winningNumbers, bonusNumber);
    }
}
