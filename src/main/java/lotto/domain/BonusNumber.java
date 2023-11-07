package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.List;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningLottoNumbers) {
        validator(bonusNumber, winningLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validator(int bonusNumber, List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
