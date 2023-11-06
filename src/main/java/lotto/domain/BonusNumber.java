package lotto.domain;

import lotto.constant.LottoConstant;

public class BonusNumber {
    int number;

    public BonusNumber(int number, WinningNumber winningNumber) {
        rangeValidate(number);
        duplicationValidate(number, winningNumber);
        this.number = number;
    }

    public int get() {
        return number;
    }

    private void rangeValidate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicationValidate(int number, WinningNumber winningNumber) {
        for (int i = 0; i < LottoConstant.LOTTO_LENGTH; i++) {
            if (number == winningNumber.get(i)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
