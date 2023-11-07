package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private int number;

    public LottoNumber() {
        this.number = createRandomNumber();
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }
}
