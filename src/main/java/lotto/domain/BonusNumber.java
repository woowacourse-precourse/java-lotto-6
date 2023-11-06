package lotto.domain;

import lotto.exception.LottoExceptionMessage;

public class BonusNumber {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber) {
        try {
            return new BonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(LottoExceptionMessage.BONUS_NUMBER_MUST_BETWEEN_START_AND_END_INCLUSIVE.getMessage());
        }
        return null;
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < START_INCLUSIVE || bonusNumber > END_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
    }

}
