package lotto.service;

import lotto.model.LottoBuyer;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoGameService {
    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;

    public LottoGameService(ConsoleInputView inputView, ConsoleOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int calculateLottoCountOnBuy(final LottoBuyer buyer) {
        outputView.requestPurchaseAmount();
        try {
            int purchaseAmount = readPurchaseAmount();
            buyer.pay(purchaseAmount);
            return buyer.getCountOfLotto();
        } catch (IllegalArgumentException e) {
            handleIllegalArgumentException(e);
            return calculateLottoCountOnBuy(buyer);
        }
    }

    private int readPurchaseAmount() {
        return inputView.readPurchaseAmount();
    }

    private void handleIllegalArgumentException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
