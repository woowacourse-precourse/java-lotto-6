package lotto.view;

import lotto.domain.PurchaseBudget;

import static lotto.constants.InputMessage.DEMAND_INPUT_BUDGET;
import static lotto.util.InputUtils.readInt;

public class InputView {

    public static PurchaseBudget getPurchaseBudget() {
        try {
            println(DEMAND_INPUT_BUDGET.getMessage());
            return new PurchaseBudget(readInt());
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return getPurchaseBudget();
        }
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
