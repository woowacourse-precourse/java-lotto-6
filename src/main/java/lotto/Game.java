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

        List<Integer> winningNumbers;
        int bonusNumber;
        String profitPercentage;
        int purchaseAmount = input.getValidPurchaseAmount();
        List<Lotto> totalLotto = gameManager.createLotto(purchaseAmount);

        Output.printPurchaseLottoQuantityMessage(totalLotto.size());
        Output.printTotalLotto(totalLotto);

        winningNumbers = input.getValidWinningNumbers();
        bonusNumber = input.getValidBonusNumber();

        gameManager.compareTotalLotto(totalLotto, winningNumbers, bonusNumber, winningStatistics);
        Output.printWinningStatisticsMessage();
        Output.printWinningResult(winningStatistics);

        profitPercentage = gameManager.calculateProfitPercentage(winningStatistics, purchaseAmount);
        Output.printProfitPercentage(profitPercentage);
    }
}
