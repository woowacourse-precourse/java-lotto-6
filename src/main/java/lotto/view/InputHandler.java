package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionHandler;
import lotto.exception.ExceptionStatus;

public class InputHandler {
    private static String purchaseAmount;
    private static ExceptionStatus exceptionStatus;

    public static String getPurchaseInputMessage() {
        do {
            Printer.printPurchaseAmountChoiceMessage();
            purchaseAmount = Console.readLine();
            exceptionStatus = ExceptionHandler.handleMoneyInputException(purchaseAmount);
        } while (exceptionStatus.isOccurred());

        return purchaseAmount;
    }
}
