package lotto.controller;

import lotto.model.User;
import lotto.utils.Converter;
import lotto.validator.GameValidator;
import lotto.view.InputView;

public class GameController {
    private final User user;
    private final int count;

    GameController() {
        this.count = setCount();
        this.user = new User(count);
    }

    private int setCount() {
        int money = Integer.parseInt(InputView.money());
        GameValidator.validateMoney(money);
        return Converter.moneyToCount(money);
    }

}
