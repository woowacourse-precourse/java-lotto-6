package controller;

import errorhandler.CustomIllegalArgumentException;
import errorhandler.InputException;
import java.util.List;
import model.Lotto;
import util.Validator;
import view.InputView;

public class GameService {

    public int userPurchaseLotto() {
        int money;
        while (true) {
            money = InputView.userPurchaseLotto();
            try {
                Validator.checkLottoAmmount(money);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(new CustomIllegalArgumentException(InputException.WRONG_MONEY).getMessage());
            }
        }
        return money;
    }

    public Lotto initWinningNumber() {
        List<Integer> numbers = InputView.lottoWinningNumber();
        return new Lotto(numbers);
    }
}
