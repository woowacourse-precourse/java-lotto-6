package lotto.domain;

import lotto.utils.ValidateUtils;

import java.util.List;

public class BonusNumber {
    private final int BONUS_SIZE = 1;
    private static final int LOWER_BOUND_NUMBER = 1;
    private static final int UPPER_BOUND_NUMBER = 45;
    private final int bonusNumber;
    private ValidateUtils validateUtils = new ValidateUtils();

    public BonusNumber(int bonusNumber, Lotto lotto) {
        validateRange(bonusNumber, LOWER_BOUND_NUMBER, UPPER_BOUND_NUMBER);
        validateUniqueBonusNumber(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String inputString, Lotto lotto) {
        ValidateUtils.validateNumeric(inputString);
        return new BonusNumber(Integer.parseInt(inputString), lotto);
    }

    public void validateUniqueBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.lottoContainNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void validateRange(int number, int lowerBound, int upperBound) {
        if (number < lowerBound || number > upperBound) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
