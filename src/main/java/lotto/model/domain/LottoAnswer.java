package lotto.model.domain;

import java.util.List;
import lotto.util.LottoGameException;

public class LottoAnswer extends Lotto {
    private Integer bonusNumber;

    public LottoAnswer(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw LottoGameException.DUPLICATED_BONUS_NUMBER.makeException();
        }
    }
}
