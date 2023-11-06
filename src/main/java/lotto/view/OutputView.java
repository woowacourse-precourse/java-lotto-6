package lotto.view;

import static lotto.enums.OutputMessage.*;

public class OutputView {
    public void promptForPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT.getMessage());
    }

    public void displayPurchaseAmount(int amount) {
        System.out.printf(PURCHASE_NUMBER_OUTPUT.getMessage(), amount);
    }

    public void displayPurchaseLotto() {
        //TODO
        System.out.println();
    }

    public void promptForWinningNumbers() {
        System.out.println(WINNING_NUMBER_PROMPT.getMessage());
    }

    public void promptForBonusNumbers() {
        System.out.println(BONUS_NUMBER_PROMPT.getMessage());
    }

    public void displayWinningStatistics() {
        //TODO
        System.out.println(WINNING_STATISTICS_OUTPUT);
    }
}
