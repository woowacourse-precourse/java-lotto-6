package lotto.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberPicker implements RandomNumberRangePicker {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int COUNT_LOTTO_NUMBER = 6;

    @Override
    public List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_LOTTO_NUMBER);
    }
}
