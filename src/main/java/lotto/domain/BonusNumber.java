package lotto.domain;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.exception.DuplicatedNumberException;
import lotto.util.ModelValidator;

public class BonusNumber {
    private final Integer number;

    public BonusNumber(Integer number) {
        ModelValidator.validateOutOfRange(number,
                LottoConstant.START_LOTTO_NUMBER.value(), LottoConstant.END_LOTTO_NUMBER.value());
        this.number = number;
    }

    public boolean hasBonusNumber(List<Integer> numbers) {
        return numbers.contains(number);
    }

    public void validateBonusNumberDuplicatedByWinningNumbers(BonusNumber bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber.hasBonusNumber(winningNumbers)) {
            throw new DuplicatedNumberException();
        }
    }

    public Integer getNumber() {
        return number;
    }
}
