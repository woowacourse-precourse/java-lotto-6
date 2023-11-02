package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.utils.Converter;
import lotto.validator.GameValidator;
import lotto.view.InputView;

public class GameController {
    private User user;
    private Lotto lotto;

    GameController() {
        setUser();
        setLotto();
    }

    private void setUser() {
        try {
            this.user = new User(setCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setUser();
        }
    }

    private int setCount() {
        String money = InputView.money();
        GameValidator.validateMoney(money);
        return Converter.moneyToCount(money);
    }

    private void setLotto() {
        try {
            this.lotto = new Lotto(setLottoNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setLotto();
        }
    }

    private List<Integer> setLottoNumbers() {
        String numbers = InputView.lottoNumbers();
        GameValidator.validateNumbers(numbers);
        return Converter.stringToIntArray(numbers);
    }

}
