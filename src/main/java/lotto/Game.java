package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;
import lotto.view.Input;
import lotto.view.Output;

public class Game {
    GameManager gameManager = new GameManager();
    Input input = new Input();

    public void startGame() {
        WinningStatistics winningStatistics = new WinningStatistics();

        Output.printPurchaseAmountMessage();
        List<Lotto> totalLotto = gameManager.createLotto();

        Output.printPurchaseLottoQuantityMessage(totalLotto.size());
        Output.printTotalLotto(totalLotto);

        Output.printWinningNumberMessage();
        List<Integer> winningNumbers = input.getWinningNumbers();

        Output.printBonusNumberMessage();
        int bonusNumber = input.getBonusNumber();

        gameManager.compareTotalLotto(totalLotto, winningNumbers, bonusNumber, winningStatistics);
        Output.printWinningResult(winningStatistics);
    }
}
