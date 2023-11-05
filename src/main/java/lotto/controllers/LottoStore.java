package lotto.controllers;

import static lotto.views.MessageManager.getPurchaseAmountPromptMessage;

public class LottoStore {
    public String purchaseController() {
        getPurchaseAmountPromptMessage();

        String input = InputProcessor.readLine();

        System.out.println(input);

        InputProcessor.close();

        return input;
    }
}
