package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.ui.ConsoleMessage.REQUEST_PURCHASE_AMOUNT;

import lotto.error.exception.InvalidInputException;
import lotto.input.InputProcessor;

public class ConsoleUI {
    private InputProcessor inputProcessor = new InputProcessor();

    public void start() {
        inputPurchaseAmount();
    }

    private Integer inputPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());
        while (true) {
            String input = readLine();
            try {
                Integer purchaseAmount = inputProcessor.processPurchaseAmount(input);
                System.out.println();
                return purchaseAmount;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
