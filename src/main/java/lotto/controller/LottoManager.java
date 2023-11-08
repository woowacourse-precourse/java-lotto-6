package lotto.controller;

import static lotto.controller.UserInputController.getLottoBuyingPrice;

import lotto.domain.Lotto;
import lotto.domain.User;

public class LottoManager {
    LottoManager() {
        getUserLotto();
    }
    private void getUserLotto() {
        int buyingPrice = getLottoBuyingPrice();
        User user = new User(buyingPrice);
    }
}
