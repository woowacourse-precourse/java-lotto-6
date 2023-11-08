package lotto.model;

import static lotto.model.LottoRule.validateRange;
import static lotto.util.Utils.conversionInt;

import java.util.List;
import lotto.exception.argument.LottoNumberDuplicateException;

public class LottoBonusNumber {
    /**
     * 보너스 번호
     */
    private final int bonusNumber;

    public LottoBonusNumber(Lotto winningLotto, String inNumber) {
        int number = conversionInt(inNumber);
        validateRange(number); // 보너스 번호 검증
        validatDuplication(winningLotto, number);

        this.bonusNumber = number;
    }

    private void validatDuplication(Lotto winningLotto, int bonusNumber) {
        List<Integer> numbers = winningLotto.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new LottoNumberDuplicateException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
