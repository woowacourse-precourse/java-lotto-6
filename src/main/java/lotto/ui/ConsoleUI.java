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
            validator.validateInteger(input);
            int amount = Integer.parseInt(input);
            validator.validatePositiveInteger(amount);
            validator.validateAmountInThousands(amount);
            return amount;
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
