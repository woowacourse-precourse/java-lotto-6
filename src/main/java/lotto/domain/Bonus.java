package lotto.domain;

import java.util.List;
import lotto.dto.BonusResponse;
import lotto.validator.InputValidator;

public class Bonus {
    private final int bonusNumber;

    private Bonus(final List<Integer> answerNumbers, final int input) {
        InputValidator.validateDuplicateBonusNumber(answerNumbers, input);
        this.bonusNumber = input;
    }

    public static Bonus create(final List<Integer> answerNumbers, final int input) {
        return new Bonus(answerNumbers, input);
    }

    public BonusResponse generateBonusResponse() {
        return new BonusResponse(bonusNumber);
    }
}
