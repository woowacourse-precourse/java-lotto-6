package lotto.domain;

import java.util.List;
import lotto.constant.LottoConstant;

public class BonusNumber {
    private int number;

    public BonusNumber(int number, WinningNumbers winningNumber) {
        rangeValidate(number);
        duplicationValidate(number, winningNumber);
        this.number = number;
    }

    public int get() {
        return number;
    }

    private void rangeValidate(int number) {
        if (number < LottoConstant.LOTTO_MIN_NUMBER || number > LottoConstant.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicationValidate(int number, WinningNumbers winningNumbers) {
        List<Integer> lottoWinningNumbers = winningNumbers.getNumbers();
        for (int i = 0; i < LottoConstant.LOTTO_LENGTH; i++) {
            if (number == lottoWinningNumbers.get(i)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
