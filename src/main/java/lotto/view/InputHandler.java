package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumbers;
import lotto.exception.ExceptionHandler;
import lotto.exception.ExceptionStatus;

public class InputHandler {
    private static String purchaseAmount;
    private static String winningNumbers;
    private static String bonusNumber;
    private static ExceptionStatus exceptionStatus;

    public static String getPurchaseInputMessage() {
        do {
            Printer.printPurchaseAmountChoiceMessage();
            purchaseAmount = Console.readLine();
            exceptionStatus = ExceptionHandler.handleMoneyInputException(purchaseAmount);
        } while (exceptionStatus.isOccurred());

        Printer.printLineBreak();

        return purchaseAmount;
    }

    public static String getWinningNumberInputMessage() {
        do {
            Printer.printWinningNumberChoiceMessage();
            winningNumbers = Console.readLine();
            exceptionStatus = ExceptionHandler.handleWinningNumberInputException(winningNumbers);
        } while (exceptionStatus.isOccurred());

        Printer.printLineBreak();

        return winningNumbers;
    }

    public static String getBonusNumberInputMessage(WinningNumbers winningNumbers) {
        do {
            Printer.printBonusNumberChoiceMessage();
            bonusNumber = Console.readLine();
            exceptionStatus = ExceptionHandler.handleBonusNumberInputException(bonusNumber, winningNumbers);
        } while (exceptionStatus.isOccurred());

        return bonusNumber;
    }
}
