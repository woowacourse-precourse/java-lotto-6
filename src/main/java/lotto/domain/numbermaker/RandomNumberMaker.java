package lotto.domain.numbermaker;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberMaker implements NumberMaker {

    private static final Integer LOTTO_NUMBERS_COUNT = 6;
    private static final Integer MINIMUM_LOTTO_RANGE = 1;
    private static final Integer MAXIMUM_LOTTO_RANGE = 45;

    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MINIMUM_LOTTO_RANGE,
                MAXIMUM_LOTTO_RANGE,
                LOTTO_NUMBERS_COUNT
        );
    }

}
