package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class RandomNumber {
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;
    private static final Integer LOTTO_NUMBER_KIND = 6;
    private static final Integer RANDOM_NUMBER_EDGE = 0;

    public List<Integer> RandomLottoOutputNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_KIND);
        return null;
    }

}
