package lotto.controllers;

import static lotto.model.InputValidator.validateDivisibleByThousand;
import static lotto.model.InputValidator.validateNonInteger;
import static lotto.model.Utilities.inputIntegerParsing;
import static lotto.views.MessageManager.*;

public class LottoStoreManager {
    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    public void purchaseController() {
        getPurchaseAmountPromptMessage();

        setInput(InputProcessor.readLine());

        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                validateNonInteger(input);
                validateDivisibleByThousand(inputIntegerParsing(input));
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                input = InputProcessor.readLine();
                attempts++;
            }
        }


        if (attempts == maxAttempts) {
            getProgramClosePromoptMessage();
        }
        InputProcessor.close();
    }
}
