package lotto.model;

import lotto.validation.PurchaseAmountValidator;
import lotto.view.OutputView;

public class PurchaseAmount {

    private int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int buyLotto(int lottoPrice) {
        int lottoCount = calculateLottoCount(lottoPrice);
        int totalPrice = lottoPrice * lottoCount;

        amount -= totalPrice;
        displayPurchasedLottoQuantity(lottoCount);

        return lottoCount;
    }

    private void displayPurchasedLottoQuantity(int count) {
        OutputView.printPurchasedLottoQuantity(count);
    }

    private int calculateLottoCount(int lottoPrice) {
        return amount / lottoPrice;
    }

    private void validate(int amount) {
        PurchaseAmountValidator.validate(amount);
    }
}
