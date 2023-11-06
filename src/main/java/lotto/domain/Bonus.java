package lotto.domain;

import lotto.dto.BonusResponse;

public class Bonus {
    private final int bonusNumber;

    private Bonus(final int input) {
        this.bonusNumber = input;
    }

    public static Bonus create(final int input) {
        return new Bonus(input);
    }

    public BonusResponse generateBonusResponse() {
        return new BonusResponse(bonusNumber);
    }
}
