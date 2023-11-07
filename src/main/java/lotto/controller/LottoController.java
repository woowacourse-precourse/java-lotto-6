package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.service.LottoPurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        String purchaseAmount = getPurchaseAmount();
        LottoTicket lottoTicket = getLottoTicket(purchaseAmount);

    }

    private String getPurchaseAmount() {
        try{
            OutputView.printEnterPurchaseAmount();
            return InputView.getInputPurchaseAmount();
        }
        catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            return getPurchaseAmount();
        }

    }
    private LottoTicket getLottoTicket(String purchaseAmount) {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        return lottoPurchaseService.purchaseLottoTicket(purchaseAmount);
    }
}
