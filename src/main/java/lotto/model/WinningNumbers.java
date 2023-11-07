package lotto.model;

import static lotto.common.ExceptionMessage.MAIN_AND_BONUS_NUMBERS_DUPLICATE_ERROR;

public class WinningNumbers {
    private final MainNumbers mainNumbers;
    private final BonusNumber bonusNumber;

    private WinningNumbers(MainNumbers mainNumbers, BonusNumber bonusNumber) {
        validate(mainNumbers, bonusNumber);

        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(MainNumbers mainNumbers, BonusNumber bonusNumber) {
        return new WinningNumbers(mainNumbers, bonusNumber);
    }

    private void validate(MainNumbers mainNumbers, BonusNumber bonusNumber) {
        validateDistinctMainAndBonusNumbers(mainNumbers, bonusNumber);
    }

    private void validateDistinctMainAndBonusNumbers(MainNumbers mainNumbers, BonusNumber bonusNumber) {
        if (containsDuplicateNumber(mainNumbers, bonusNumber)) {
            throw new IllegalArgumentException(MAIN_AND_BONUS_NUMBERS_DUPLICATE_ERROR);
        }
    }

    private boolean containsDuplicateNumber(MainNumbers mainNumbers, BonusNumber bonusNumber) {
        return mainNumbers.hasNumber(bonusNumber.getBonusNumber());
    }
}
