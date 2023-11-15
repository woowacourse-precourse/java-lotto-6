package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoNumber;
import lotto.service.LottoService;
import lotto.service.ProfitsService;
import lotto.service.PurchasingService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private PurchasingService purchasingService = new PurchasingService();
    private LottoService lottoService = new LottoService();
    private LottoNumber lottoNumber = new LottoNumber();
    private ProfitsService profitsService;
    private Buyer buyer;

    public void run() {
        purchaseLotto();
        showPurchaseLotto();
        setWinningNumbers();
        setBonusNumber();
        showWiningResult();
        showRateOfReturn();
    }

    private void purchaseLotto() {
        try {
            buyer = purchasingService.purchaseLotto(InputView.enterPurchaseAmount());
            OutputView.printSpace();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            purchaseLotto();
        }
    }

    private void showPurchaseLotto() {
        OutputView.printPurchaseLotto(buyer);
        OutputView.printSpace();
    }

    private void setWinningNumbers() {
        try {
            lottoNumber.drawWiningNumbers(InputView.enterWinningNumbers());
            OutputView.printSpace();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            setWinningNumbers();
        }
    }

    private void setBonusNumber() {
        try {
            lottoNumber.drawBonusNumber(InputView.enterBonusNumbers());
            OutputView.printSpace();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            setBonusNumber();
        }
    }

    private void showWiningResult() {
        lottoService.compareLottoNumber(buyer, lottoNumber);
        OutputView.printWiningWiningResult(lottoService);
    }

    private void showRateOfReturn() {
        profitsService = new ProfitsService(buyer);
        profitsService.calculateRateOfReturn(lottoService);
        OutputView.printRateOfReturn(profitsService);
    }
}
