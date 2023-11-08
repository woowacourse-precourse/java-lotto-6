package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void displayMessage(ViewPrompt viewPrompt) {
        System.out.println(viewPrompt.getMessage());
    }

    public String promptForPurchasedPrice() {
        displayMessage(ViewPrompt.WELCOME_MESSAGE);
        String purchasedPrice = Console.readLine();
        System.out.println();

        return purchasedPrice;
    }

    public String promptForWinningCondition() {
        displayMessage(ViewPrompt.WINNING_NUMBERS_MESSAGE);
        String winningInput = Console.readLine();
        System.out.println();

        return winningInput;
    }

    public String promptForBonusNumber() {
        displayMessage(ViewPrompt.BONUS_NUMBER_MESSAGE);
        String inputBonusNumber = Console.readLine();
        System.out.println();

        return inputBonusNumber;
    }
}
