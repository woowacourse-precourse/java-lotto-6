package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.ValidationManager;

public class LottoPlayer {

    private int purchaseMoney;

    public LottoPlayer(String purchaseMoney) {
        ValidationManager.validateInput(purchaseMoney);
        validatePurchaseMoney(purchaseMoney);

        this.purchaseMoney = Integer.parseInt(purchaseMoney);
    }


    private void validatePurchaseMoney(String purchaseMoney) {
        if (isNotDivisibleWithLottoPrice(purchaseMoney)) {
            throw new IllegalStateException(ErrorMessage.INVALID_INPUT_PURCHASE_MONEY.getMessage());
        }
    }

    private boolean isNotDivisibleWithLottoPrice(String purchaseMoney) {
        return Integer.parseInt(purchaseMoney) % Constant.LOTTO_PRICE != 0;
    }


}
