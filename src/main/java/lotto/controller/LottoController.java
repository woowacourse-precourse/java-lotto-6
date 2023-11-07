package lotto.controller;

import lotto.domain.PurchaseBudget;

import static lotto.constants.InputMessage.DEMAND_INPUT_BUDGET;
import static lotto.util.InputUtils.readInt;
import static lotto.view.InputView.*;

public class LottoController {

    public void play() {
        PurchaseBudget purchaseBudget = getPurchaseBudget();
    }

    private PurchaseBudget getPurchaseBudget() {
        try {
            println(DEMAND_INPUT_BUDGET.getMessage());
            return new PurchaseBudget(readInt());
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return getPurchaseBudget();
        }
    }
}
