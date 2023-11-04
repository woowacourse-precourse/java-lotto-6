package lotto.controller;

import lotto.model.Client;
import lotto.model.LottoStore;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.View;

public class LottoController {
    View view = new View();
    LottoStore lottoStore = new LottoStore();
    PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

    public void run() {
        int purchaseAmount = payAmount();
    }

    private int payAmount() {
        view.printPurchaseAmountInputMessage();
        while (true) {
            try {
                String purchaseAmount = view.inputValue();
                purchaseAmountValidator.validate(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                view.printExceptionMessage(e);
            }
        }
    }

    private Client issueLotto(int purchaseAmount) {
        return new Client(lottoStore.issueLotto(purchaseAmount));
    }
}
