package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.List;

public class BonusNumber {

    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 45;

    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningLottoNumbers) {
        validateNumber(bonusNumber);
        validatorDuplicate(bonusNumber, winningLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    private static void validateNumber(int number) {
        if (number > END_NUMBER || number < START_NUMBER) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void validatorDuplicate(int bonusNumber, List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
