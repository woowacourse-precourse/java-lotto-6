package lotto.exception.bonusNumber;

import lotto.constant.Phrases;
import lotto.exception.CommonException;

import java.util.List;

public class BonusNumberException extends CommonException {
    public void bonusNumberDuplication(int number, List<Integer> wLotto) {
        if (wLotto.contains(number)) {
            throw new IllegalArgumentException(Phrases.bonusNumberDuplication);
        }
    }
}
