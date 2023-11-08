package lotto.model;

import java.util.Set;
import lotto.validation.BonusNumberValidation;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, Set<Integer> winningNumber) {
        BonusNumberValidation.validateBonusNumber(number, winningNumber);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
