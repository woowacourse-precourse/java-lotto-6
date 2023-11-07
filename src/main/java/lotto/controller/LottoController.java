package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.PlayerLottos;
import lotto.model.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    int money;
    PlayerLottos playerLottos;
    Lotto lotto;
    Bonus bonus;
    WinningResult winningResult;

    public void run() {
        buyPlayerLotto();

        createLotto();
        createBonus();

        calculateResult();
    }

    private void calculateResult() {
        winningResult = new WinningResult(lotto, bonus, playerLottos);

        outputView.printWinningResult(winningResult);
        outputView.printProfit(money, winningResult.getTotalRevenue());
    }

    private void buyPlayerLotto() {
        money = inputView.inputMoney();
        playerLottos = new PlayerLottos(money);

        outputView.printIssueCount(money);
        outputView.printPlayerLottos(playerLottos);
    }

    private void createBonus() {
        try {
            bonus = new Bonus(inputView.inputBonusNumber(), lotto);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            createBonus();
        }
    }

    private void createLotto() {
        try {
            lotto = new Lotto(inputView.inputLottoNumbers());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            createLotto();
        }
    }
}
