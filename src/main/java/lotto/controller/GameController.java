package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.utils.Converter;
import lotto.validator.GameValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private User user;
    private Lotto lotto;
    private int count;
    private int bonusNumber;

    public void progress() {
        setCount();
        setUser();
        OutputView.printCountAndTickets(user, count);
        setLotto();
    }

    private void setUser() {
        this.user = new User(count);
    }

    private void setCount() {
        String money = InputView.money();
        try {
            GameValidator.validateMoney(money);
            count = Converter.moneyToCount(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCount();
        }
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

    private void setBonusNumber() {
        String number = InputView.bonusNumbers();
        GameValidator.validateBonusNumber(number, lotto);
        bonusNumber = Integer.parseInt(number);
    }

}