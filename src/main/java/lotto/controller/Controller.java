package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoNumber;
import lotto.service.LottoService;
import lotto.service.PurchasingService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private PurchasingService purchasingService = new PurchasingService();
    private LottoService lottoService = new LottoService();
    private LottoNumber lottoNumber = new LottoNumber();
    private Buyer buyer;

    public void run() {
     purchaseLotto();
     showPurchaseLotto();
     setWinningNumbers();
     setBonusNumber();
     showWiningResult();


    }

    private void purchaseLotto() {
        String amount = InputView.enterPurchaseAmount();
        buyer = purchasingService.purchaseLotto(amount);
    }

    private void showPurchaseLotto() {
        OutputView.printPurchaseLotto(buyer);
    }

    private void setWinningNumbers() {
        lottoNumber.drawWiningNumbers(InputView.enterWinningNumbers());
    }

    private void setBonusNumber() {
        lottoNumber.drawBonusNumber(InputView.enterBonusNumbers());
    }

    private void showWiningResult() {
        lottoService.compareLottoNumber(buyer, lottoNumber);
        OutputView.printWiningWiningResult(lottoService);

    }
}
