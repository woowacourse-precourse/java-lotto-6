package lotto.model;

import lotto.constant.GameConfig;
import lotto.validation.PurchaseAmountValidator;

public class PurchaseAmount {

    private int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
    }

    public int calculateLottoCount() {
        GameConfig lottoPrice = GameConfig.LOTTO_PRICE;
        return amount / lottoPrice.getValue();
    }

    public boolean buyLotto(int lottoCount) {
        GameConfig lottoPrice = GameConfig.LOTTO_PRICE;
        int totalPrice = lottoPrice.getValue() * lottoCount;

        if (amount < totalPrice) {
            return false;
        }

        amount -= totalPrice;
        return true;
    }

    private void validate(int amount) {
        PurchaseAmountValidator.validate(amount);
    }
}
