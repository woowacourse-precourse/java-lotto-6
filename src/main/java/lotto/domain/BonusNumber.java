package lotto.domain;

import lotto.global.utils.constant.LottoNumberType;
import lotto.global.utils.constant.OutputType;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lottoNumbers, int bonusNumber) {
        List<Integer> numbers = lottoNumbers.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(OutputType.EXCEPTION_INPUT_REDUNDANT.getComment());
        }
        if (bonusNumber < LottoNumberType.MIN_NUMBER_OF_RANGE.getValue()
                || bonusNumber > LottoNumberType.MAX_NUMBER_OF_RANGE.getValue()) {
            throw new IllegalArgumentException(OutputType.EXCEPTION_INPUT_RANGE.getComment());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
