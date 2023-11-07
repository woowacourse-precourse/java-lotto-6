package lotto;

import static lotto.message.ErrorMessage.DIVISIBLE_BY_1000;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_MONEY;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_WINNING_NUMBERS;
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

        int purchaseAmount = validatePurchaseAmount();
        List<Lotto> totalLotto = gameManager.createLotto(purchaseAmount);
        List<Integer> winningNumbers;

        Output.printPurchaseLottoQuantityMessage(totalLotto.size());
        Output.printTotalLotto(totalLotto);

        winningNumbers = validateWinningNumbers();

        Output.printBonusNumberMessage();
        int bonusNumber = input.getBonusNumber();

        gameManager.compareTotalLotto(totalLotto, winningNumbers, bonusNumber, winningStatistics);
        Output.printWinningStatisticsMessage();
        Output.printWinningResult(winningStatistics);

        double profitPercentage = gameManager.calculateProfitPercentage(winningStatistics, purchaseAmount);
        Output.printProfitPercentage(profitPercentage);
    }

    private List<Integer> validateWinningNumbers() {
        List<Integer> winningNumbers;
        while (true){
            Output.printWinningNumberMessage();
            try {
                winningNumbers = input.getWinningNumbers();
                break;
            }catch (IllegalArgumentException e){
                checkWinningNumbersExceptionCategory(e);
            }
        }
        return winningNumbers;
    }

    private static void checkWinningNumbersExceptionCategory(IllegalArgumentException e) {
        if(e.getMessage().equals(WINNING_NUMBERS_LENGTH.errorMessage())){
            System.out.println(WINNING_NUMBERS_LENGTH.errorMessage());
        }

        if(e.getMessage().equals(WINNING_NUMBERS_RANGE.errorMessage())){
            System.out.println(WINNING_NUMBERS_RANGE.errorMessage());
        }

        if (e.getMessage().equals(NUMBER_FORMAT_WINNING_NUMBERS.errorMessage())){
            System.out.println(NUMBER_FORMAT_WINNING_NUMBERS.errorMessage());
        }
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
