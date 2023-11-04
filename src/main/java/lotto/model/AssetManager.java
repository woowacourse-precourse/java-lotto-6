package lotto.model;

import lotto.ErrorMessages;

public class AssetManager {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private final Integer budget;
    private int lottoTickets;

    public AssetManager(int budget) {
        validateBudget(budget);
        this.budget = budget;
    }

    private void buyLotto() {
        this.lottoTickets = this.budget / LOTTO_PRICE;
    }

    private void validateBudget(int budget) throws IllegalArgumentException {
        if (budget % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ErrorMessages.NOT_ALLOW_REMAINDER.toString());
        }

        if (budget < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LOW_BUDGET.toString());
        }
    }
}
