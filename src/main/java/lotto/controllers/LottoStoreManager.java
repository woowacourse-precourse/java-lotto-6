package lotto.controllers;

import static lotto.model.InputValidator.validateDivisibleByThousand;
import static lotto.model.InputValidator.validateNonInteger;
import static lotto.model.Utilities.divide;
import static lotto.model.Utilities.inputIntegerParsing;
import static lotto.views.MessageManager.*;

public class LottoStoreManager {
    private String inputAmount;
    private final double LOTTO_PRICE = 1000;

    public void setInput(String inputAmount) {
        this.inputAmount = inputAmount;
    }

    public void purchaseController() {
        setInput(InputProcessor.readLine());

        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                validateNonInteger(inputAmount);
                validateDivisibleByThousand(inputIntegerParsing(inputAmount));
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                inputAmount = InputProcessor.readLine();
                attempts++;
            }
        }

        if (attempts == maxAttempts) {
            getProgramClosePromoptMessage();
        }
        InputProcessor.close();
    }

    public int lottoMachine(String inputAmount) {
        return (int) divide(Double.parseDouble(inputAmount), LOTTO_PRICE);
    }
}
