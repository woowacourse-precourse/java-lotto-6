package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.function.Supplier;

public class LottoNumSupplier implements Supplier<Integer> {
    private final static int MIN_LOTTO_NUM = 1;
    private final static int MAX_LOTTO_NUM = 45;
    @Override
    public Integer get() {
        return Randoms.pickNumberInRange(MIN_LOTTO_NUM,MAX_LOTTO_NUM);
    }
}
