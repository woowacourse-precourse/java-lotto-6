package lotto.controller;

import lotto.model.Money;
import lotto.model.User;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private User user;
    private WinningLotto winningLotto;

    public void startGame() {
        setUserLotto();
        printUserLottos();
        setWinningLotto();
        calculateLottoStatistics();
        printLottoStatistics();
    }

    private void setUserLotto() {
        Money money;
        try {
            money = new Money(InputView.readMoney());
            user = new User(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setUserLotto();
        }
    }

    private void printUserLottos() {
        OutputView.printUserLottos(user.getLottos());
    }

    private void setWinningLotto() {
        try {
            winningLotto = new WinningLotto(InputView.readLotto(), InputView.readBonus());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinningLotto();
        }
    }

    private void calculateLottoStatistics() {

    }

    private void printLottoStatistics() {

    }

}
