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
        printLottoResult();
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
        int bonus = inputController.readBonus(lotto.getNumbers());
        winningLotto = new WinningLotto(lotto, bonus);
    }

    private void calculateLottoStatistics() {
        user.calculateLottoResults(winningLotto);
        results = user.getLottoResults();
        statistics = user.calculateStatistics();
    }

    private void printLottoResult() {
        OutputView.printLottoResult(results);
    }

    private void printLottoStatistics() {
        OutputView.printLottoStatistics(statistics);
    }

}
