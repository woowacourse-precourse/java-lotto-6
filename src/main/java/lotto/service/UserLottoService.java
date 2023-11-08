package lotto.service;

import lotto.validator.PurchaseValidator;

import java.util.List;

import lotto.config.Config;
import lotto.domain.Lotto;
import lotto.domain.User;

public class UserLottoService {
    User user;

    public void setUser(int ticketCount, int purchaseAmount) {
        user = new User(ticketCount, purchaseAmount);
        user.setLotto();
    }

    public User getUser() {
        return user;
    }

    public List<Lotto> getLottoList() {
        return user.getLottoList();
    }

    public int parseIntPurchaseAmount(String purchaseAmountStr) {
        PurchaseValidator.validateIntegerInput(purchaseAmountStr);
        int purchaseAmount = Integer.parseInt(purchaseAmountStr);
        PurchaseValidator.validateIsDivisible(purchaseAmount);
        return purchaseAmount;
    }

    public int createLottoCount(int purchaseAmount) {
        return purchaseAmount / Config.LOTTO_PRICE;
    }
}
