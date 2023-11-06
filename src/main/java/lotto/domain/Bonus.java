package lotto.domain;

import lotto.dto.BonusResponse;
import lotto.parser.Parser;

public class Bonus {
    private final int bonusNumber;

    private Bonus(final String input) {
        this.bonusNumber = Parser.parseBonusNumber(input);
    }

    public static Bonus create(final String input) {
        return new Bonus(input);
    }

    public BonusResponse bonusResponse() {
        return new BonusResponse(bonusNumber);
    }
}
