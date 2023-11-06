package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.model.User;
import lotto.model.WinningLotto;
import lotto.view.OutputView;

public class GameController {

    private final InputController inputController;
    private User user;
    private WinningLotto winningLotto;
    private List<LottoResult> results;
    private double statistics;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void startGame() {
        setUser();
        printUserLottos();
        setWinningLotto();
        calculateLottoStatistics();
        printLottoStatistics();
    }

    private void setUser() {
        Money money = inputController.readMoney();
        user = new User(money);
    }

    private void printUserLottos() {
        OutputView.printUserLottos(user.getLottos());
    }

    private void setWinningLotto() {
        Lotto lotto = inputController.readLotto();
        int bonus = inputController.readBonus(lotto.numbers());
        winningLotto = new WinningLotto(lotto, bonus);
    }

    private void calculateLottoStatistics() {
        results = user.getLottoResults(winningLotto);
        statistics = user.getStatistics();
    }

    private void printLottoStatistics() {
        OutputView.printLottoStatistics(results, statistics);
    }

}
