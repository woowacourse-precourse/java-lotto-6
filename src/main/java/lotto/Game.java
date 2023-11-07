package lotto;

import static lotto.message.ErrorMessage.BONUS_NUMBER_RANGE;
import static lotto.message.ErrorMessage.DIVISIBLE_BY_1000;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_BONUS_NUMBER;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_MONEY;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_WINNING_NUMBERS;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_DUPLICATE;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_LENGTH;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_RANGE;

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

        int purchaseAmount = input.getValidPurchaseAmount();
        List<Integer> winningNumbers;
        int bonusNumber;
        List<Lotto> totalLotto = gameManager.createLotto(purchaseAmount);
        double profitPercentage;

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
