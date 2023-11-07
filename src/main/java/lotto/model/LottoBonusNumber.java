package lotto.model;

import static lotto.model.LottoRule.validateRange;
import static lotto.util.Utils.conversionInt;

import java.util.List;
import lotto.exception.LottoNumberDuplicateException;

public class LottoBonusNumber {
    /**
     * 보너스 번호
     */
    private final int bonusNumber;

    public LottoBonusNumber(LottoWinningNumbers winningNumbers, String inNumber) {
        int number = conversionInt(inNumber);
        validateRange(number); // 보너스 번호 검증
        validatDuplication(winningNumbers, number);

        this.bonusNumber = number;
    }

    private void validatDuplication(LottoWinningNumbers winningNumbers, int bonusNumber) {
        List<Integer> numbers = winningNumbers.getLottoNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new LottoNumberDuplicateException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
