package lotto.service;

import lotto.validator.PurchaseValidator;
import lotto.config.Config;
import lotto.domain.User;

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

    public User setUser(int createLottoNumbers, int purchaseAmount){
        return new User(createLottoNumbers, purchaseAmount);
    }
}
