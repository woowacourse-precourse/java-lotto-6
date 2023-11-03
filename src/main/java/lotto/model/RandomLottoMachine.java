package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Constant;

import java.util.List;

public class RandomLottoGenerator implements LottoGenerator{
    private static final int LOTTO_SIZE = Constant.LOTTO_SIZE.getValue();
    private static final int MIN_LOTTO_NUMBER = Constant.MIN_LOTTO_NUMBER.getValue();
    private static final int MAX_LOTTO_NUMBER = Constant.MAX_LOTTO_NUMBER.getValue();

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
    }
}
