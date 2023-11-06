package lotto.domain;

import static lotto.util.Constants.LOTTO_ONE_GAME_PRICE;
import static lotto.domain.exception.BudgetException.INVALID_UNIT_OF_BUDGET;

public class Budget {
    private final int budget;

    public Budget(int budget) {
        this.budget = budget;
    }

    public int makeTicket() {
        if (canMakeTicket()) {
            throw new IllegalArgumentException(INVALID_UNIT_OF_BUDGET.getMessage());
        }
        return budget / LOTTO_ONE_GAME_PRICE;
    }

    private boolean canMakeTicket() {
        return budget <= 0 || budget % LOTTO_ONE_GAME_PRICE != 0;
    }
}
