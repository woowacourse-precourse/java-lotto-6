package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConst.MIN_RANGE_NUMBER.getValue(), LottoConst.MAX_RANGE_NUMBER.getValue(), LottoConst.LOTTO_NUMBER_COUNT.getValue());
        return numbers;
    }
}
