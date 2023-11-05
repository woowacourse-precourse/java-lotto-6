package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidation;

public class InputView {
    private final InputValidation inputValidation = new InputValidation();

    public int purchaseCost() {
        while(true) {
            try {
                String purchaseCost = Console.readLine();

                inputValidation.validatePurchaseCost(purchaseCost);

                return Integer.parseInt(purchaseCost);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
