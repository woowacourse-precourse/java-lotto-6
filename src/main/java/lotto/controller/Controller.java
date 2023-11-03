package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoMachine;
import lotto.service.PurchasingService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private PurchasingService purchasingService = new PurchasingService();
    private LottoMachine lottoMachine = new LottoMachine();
    private Buyer buyer;

    public void run() {
     purchaseLotto();
     showPurchaseLotto();
     setWinningNumbers();
     setBonusNumber();


    }

    private void purchaseLotto() {
        String amount = InputView.enterPurchaseAmount();
        buyer = purchasingService.purchaseLotto(amount);
    }

    private void showPurchaseLotto() {
        OutputView.printPurchaseLotto(buyer);
    }

    private void setWinningNumbers() {
        lottoMachine.drawWiningNumbers(InputView.enterWinningNumbers());
    }

    private void setBonusNumber() {
        lottoMachine.drawBonusNumber(InputView.enterBonusNumbers());
    }
}
