package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Validator;

public class ConsoleUI {
    private final Validator validator;

    public ConsoleUI(Validator validator) {
        this.validator = validator;
    }

    public int getPurchaseAmount() {
        int lottoPurchaseCost;
        do {
            lottoPurchaseCost = attemptToGetValidPurchaseAmount();
        } while (lottoPurchaseCost == -1);
        return lottoPurchaseCost;
    }

    private int attemptToGetValidPurchaseAmount() {
        try {
            String input = promptForPurchaseAmount();
            return validator.validatePurchaseAmountInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    private String promptForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}
