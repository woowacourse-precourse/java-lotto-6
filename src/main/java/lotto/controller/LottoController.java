package lotto.controller;

import lotto.model.Client;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.View;

public class LottoController {
    View view = new View();
    LottoStore lottoStore = new LottoStore();
    PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

    public void run() {
        Client client = purchaseLotto(payAmount());
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

    private Client purchaseLotto(int purchaseAmount) {
        Client client = new Client();
        int purchasedLottoAmount = lottoStore.calculatePurchasedLottoCount(purchaseAmount);
        view.printPurchaseLottoAmount(purchasedLottoAmount);
        for (double issuedLottoCount = 1; issuedLottoCount <= purchasedLottoAmount; issuedLottoCount++) {
            Lotto lotto = lottoStore.createRandomLotto();
            view.printIssuedLotto(lotto.toString());
            client.addLotto(lotto);
        }
        return client;
    }
}
