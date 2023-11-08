package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.Error;
import lotto.message.Inquire;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

    private final OutputHandler outputHandler;

    public InputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public int getValidPurchaseAmountFromUser() throws IllegalArgumentException {
        outputHandler.printMessage(Inquire.PURCHASE_AMOUNT);
        String userInput = getUserInput();
        validatePurchaseAmount(userInput);
        return Integer.parseInt(userInput);
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private void validatePurchaseAmount(String userInput) {
        validatePositiveInteger(userInput);
        validateThousandUnits(userInput);
        validateProperPurchaseAmount(userInput);
    }

    private void validatePositiveInteger(String userInput) {
        if (!isPositiveInteger(userInput)) {
            throw new IllegalArgumentException(Error.POSITIVE_INTEGER.getMessage());
        }
    }

    private void validateThousandUnits(String userInput) {
        int purchaseAmount = Integer.parseInt(userInput);
        if (!isThousandUnits(purchaseAmount)) {
            throw new IllegalArgumentException(Error.THOUSAND_UNITS.getMessage());
        }
    }

    private void validateProperPurchaseAmount(String userInput) {
        int purchaseAmount = Integer.parseInt(userInput);
        if (!isProperAmount(purchaseAmount)) {
            throw new IllegalArgumentException(Error.MAX_PURCHASE_LIMIT.getMessage());
        }
    }

    private static boolean isProperAmount(int purchaseAmount) {
        return purchaseAmount <= 100_000;
    }

    private boolean isPositiveInteger(String str) {
        Pattern pattern = Pattern.compile("^[1-9]\\d*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private boolean isThousandUnits(int purchaseAmount) {
        return purchaseAmount % 1000 == 0;
    }


    public String getWinningNumbersFromUser() {
        outputHandler.printMessage(Inquire.WINNER_NUMBERS);
        return getUserInput();
    }

    public int getBonusNumberFromUser() {
        outputHandler.printMessage(Inquire.BONUS_NUMBER);
        return Integer.parseInt(getUserInput());
    }
}
