package lotto;

import lotto.exception.LottoNumberOutOfRangeException;

public class LottoNumber {
    private final int num;

    public LottoNumber(int num) {
        if (num < 1 || num > 45) {
            throw new LottoNumberOutOfRangeException();
        }
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
