package lotto.domain;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.constant.NumberRange;

public class BonusNumber {
    private int number;

    public BonusNumber(int number, final WinningNumbers winningNumber) {
        rangeValidate(number);
        duplicationValidate(number, winningNumber);
        this.number = number;
    }

    public int get() {
        return number;
    }

    private void rangeValidate(int number) {
        if (number < NumberRange.MIN.getNumber() || number > NumberRange.MAX.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicationValidate(int number, final WinningNumbers winningNumbers) {
        List<Integer> lottoWinningNumbers = winningNumbers.getNumbers();
        for (int i = 0; i < LottoConstant.LOTTO_LENGTH; i++) {
            if (number == lottoWinningNumbers.get(i)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
