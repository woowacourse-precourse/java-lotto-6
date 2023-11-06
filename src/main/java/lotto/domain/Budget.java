package lotto.domain;

import static lotto.util.Constants.LOTTO_ONE_GAME_PRICE;

public class Budget {
    private final int budget;

    public Budget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public int makeTicket() {
        if (canMakeTicket()) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 입력해야 합니다.");
        }
        return budget / LOTTO_ONE_GAME_PRICE;
    }

    private boolean canMakeTicket() {
        return budget % LOTTO_ONE_GAME_PRICE != 0;
    }
}
