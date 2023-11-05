package lotto.service;

import lotto.validator.PurchaseValidator;
import lotto.config.Config;

public class UserLottoService {

    public int parseIntPurchaseAmount(String purchaseAmountStr) {
        PurchaseValidator.validateIntegerInput(purchaseAmountStr);
        int purchaseAmount = Integer.parseInt(purchaseAmountStr);
        PurchaseValidator.validateIsDivisible(purchaseAmount);
        return purchaseAmount;
    }

    public int createLottoCount(int purchaseAmount) {
        return purchaseAmount / Config.LOTTO_PRICE;
    }

    public void createLottos(int createLottoNumbers) {

    }
}
