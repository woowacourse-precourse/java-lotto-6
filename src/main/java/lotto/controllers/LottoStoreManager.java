package lotto.controllers;

import static lotto.model.InputValidator.validateNonInteger;
import static lotto.views.MessageManager.getPurchaseAmountPromptMessage;

public class LottoStoreManager {
    public String purchaseController() {
        getPurchaseAmountPromptMessage();

        String input = InputProcessor.readLine();
        int maxAttempts = 10;
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                validateNonInteger(input);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                input = InputProcessor.readLine();
                attempts++;
            }
        }

        if (attempts == maxAttempts) {
            System.err.println("입력이 유효하지 않습니다. 프로그램을 종료합니다.");
        }
        return input;
    }
}
