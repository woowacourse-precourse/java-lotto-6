package lotto.model;

import lotto.validation.PurchaseAmountValidator;

public class PurchaseAmount {

    private int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
    }

    public int buyLotto(int lottoPrice) {
        int lottoCount = calculateLottoCount(lottoPrice);
        int totalPrice = lottoPrice * lottoCount;

        amount -= totalPrice;
        return lottoCount;
    }

    private int calculateLottoCount(int lottoPrice) {
        return amount / lottoPrice;
    }

    private void validate(int amount) {
        PurchaseAmountValidator.validate(amount);
    }
}
