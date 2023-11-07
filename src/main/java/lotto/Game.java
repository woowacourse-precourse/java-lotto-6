package lotto;

import static lotto.message.ErrorMessage.DIVISIBLE_BY_1000;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_MONEY;

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

        int purchaseAmount = validatePurchaseAmount();
        List<Lotto> totalLotto = gameManager.createLotto(purchaseAmount);

        Output.printPurchaseLottoQuantityMessage(totalLotto.size());
        Output.printTotalLotto(totalLotto);
        Output.printWinningNumberMessage();

        List<Integer> winningNumbers = input.getWinningNumbers();

        Output.printBonusNumberMessage();
        int bonusNumber = input.getBonusNumber();

        gameManager.compareTotalLotto(totalLotto, winningNumbers, bonusNumber, winningStatistics);
        Output.printWinningStatisticsMessage();
        Output.printWinningResult(winningStatistics);

        double profitPercentage = gameManager.calculateProfitPercentage(winningStatistics, purchaseAmount);
        Output.printProfitPercentage(profitPercentage);
    }

    private int validatePurchaseAmount() {
        int purchaseAmount;

        while (true) {
            Output.printPurchaseAmountMessage();
            try {
                purchaseAmount = input.getPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                checkPurchaseAmountExceptionCategory(e);
            }
        }

        return purchaseAmount;
    }

    private void checkPurchaseAmountExceptionCategory(IllegalArgumentException e) {
        if (e.getMessage().equals(NUMBER_FORMAT_MONEY.errorMessage())) {
            System.out.println(NUMBER_FORMAT_MONEY.errorMessage());
        }

        if (e.getMessage().equals(DIVISIBLE_BY_1000.errorMessage())) {
            System.out.println(DIVISIBLE_BY_1000.errorMessage());
        }
    }
}
